package com.capstone.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails user1 = User.builder().username("shiva@gmail.com").password(passwordEncoder().encode("shiva"))
				.roles("ADMIN").build();

		UserDetails user2 = User.builder().username("nowshad@gmail.com").password(passwordEncoder().encode("nowshad"))
				.roles("EMPLOYEE").build();

		UserDetails user3 = User.builder().username("manoj@gmail.com").password(passwordEncoder().encode("manoj"))
				.roles("ADMIN").build();

		UserDetails user4 = User.builder().username("tharun@gmail.com").password(passwordEncoder().encode("tharun"))
				.roles("ADMIN").build();

		return new InMemoryUserDetailsManager(user1, user2, user3, user4);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

}