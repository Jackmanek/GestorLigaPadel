package com.ligapadel.GestorLigaPadel;

import com.ligapadel.GestorLigaPadel.entity.ERole;
import com.ligapadel.GestorLigaPadel.entity.Role;
import com.ligapadel.GestorLigaPadel.entity.User;
import com.ligapadel.GestorLigaPadel.repository.RoleRepository;
import com.ligapadel.GestorLigaPadel.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class GestorLigaPadelApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorLigaPadelApplication.class, args);
	}

	@Bean
	public ApplicationRunner configure(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
		return env -> {




			String pass = "quieroser12";
			User admin = new User("admin", "age002@gmail.com", encoder.encode(pass));
			userRepository.save(admin);

		};
	}

}
