package com.softserv.security.OAuth2;

import com.softserv.security.OAuth2.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by jarki on 7/1/2017.
 */
public class CustomUserDetails implements UserDetails {
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;




    public CustomUserDetails(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        List<GrantedAuthority> auth = new ArrayList<>();
        user.getRoles().forEach(role -> auth.add(new SimpleGrantedAuthority(role.getName())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
