package com.softserv.security.OAuth2.repository;

import com.softserv.security.OAuth2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jarki on 7/1/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
