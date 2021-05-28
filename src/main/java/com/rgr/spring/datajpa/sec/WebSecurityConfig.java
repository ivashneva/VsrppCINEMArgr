package com.rgr.spring.datajpa.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableConfigurationProperties
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService service;
//qqqqq https://habr.com/ru/company/otus/blog/488418/

//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            //    .antMatchers("/", "/home").access("hasRole('GUEST')")
//                .antMatchers("/api/tutorials/**").hasRole("ADMIN")
//                .and().httpBasic()
//                .and()
//
//                // some more method calls
//                .formLogin();
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
               // .authorizeRequests().anyRequest().authenticated()
           //     .authorizeRequests().antMatchers("/api/tutorialsput/**","/api/filminsert/**").authenticated()
                .authorizeRequests().antMatchers("/api/produsseradmin/**","/api/filmadmin/**").hasRole("ADMIN")

                .and().httpBasic()
                .and().sessionManagement().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {
        builder.userDetailsService(service);
    }
}