package com.example.restapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.restapi.model.User;
import com.example.restapi.repository.UserRepository;

@Configuration
public class DataLoader {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository) {
		return args -> {
			User user = new User();
			user.setName("admin");
			user.setEmail("admin@example.com");
			user.setPassword(passwordEncoder.encode("password")); // Certifique-se de que a entidade User possui um
																	// campo de senha
			userRepository.save(user);
		};
	}
}
