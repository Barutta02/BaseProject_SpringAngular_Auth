package com.barutta02.authsystem;

import com.barutta02.authsystem.role.Role;
import com.barutta02.authsystem.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableJpaAuditing(auditorAwareRef = "auditorAware") // Enable JPA Auditing with the given AuditorAware bean name present in /config 
@EnableAsync
@SpringBootApplication
public class AuthsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthsystemApplication.class, args);
	}

	/*
	 * This method is used to create a default role if it does not exist in the database.
	 	  Definisce un bean di tipo CommandLineRunner, che viene utilizzato per eseguire codice durante la fase di avvio dell'applicazione Spring Boot.
	 */
	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(Role.builder().name("USER").build());
			}
		};
	}
}
