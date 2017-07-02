package com.softserv.security.OAuth2;

import com.softserv.security.OAuth2.domain.Role;
import com.softserv.security.OAuth2.domain.User;
import com.softserv.security.OAuth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@SpringBootApplication
public class OAuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2Application.class, args);
	}

@Autowired
	public void authenticationManger(AuthenticationManagerBuilder builder, UserRepository userRepository) throws Exception {
		if(userRepository.count() == 0){
			User user = new User();
			user.setEmail("jarkin.123789@gmail.com");
			user.setFirstName("Jarik");
			user.setLastName("Varsh");
			user.setPassword("qwerty");
			Set<Role> roleSet = new HashSet<>();
			roleSet.add(new Role("Role_User"));
			roleSet.add(new Role("Role_Admin"));
			user.setRoles(roleSet);
			userRepository.save(user);



		}
		builder.userDetailsService(email -> new CustomUserDetails(userRepository.findByEmail(email)));

	}
}
