package com.rgr.spring.datajpa.sec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserMy, Long> {
    UserMy findUserByUsername(String username);
}
