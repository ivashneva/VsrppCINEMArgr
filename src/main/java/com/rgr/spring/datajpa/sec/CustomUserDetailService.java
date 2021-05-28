package com.rgr.spring.datajpa.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService{
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		UserMy user = repository.findUserByUsername(username);
		if(user == null) throw new UsernameNotFoundException(username);
		List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getAuthority()));
	//	String string="user";
	//qqqqq
		System.out.println("CustomUserDetailService---001 "+user.getUsername()+"--->|"+user.getPassword()+"| |" + grantedAuthorities + "|");
		return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}
