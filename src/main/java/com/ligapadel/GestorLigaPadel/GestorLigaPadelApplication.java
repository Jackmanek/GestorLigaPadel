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


			Role r = new Role(ERole.ROLE_USER);
			Role r1 = new Role(ERole.ROLE_MODERATOR);
			Role r2 = new Role(ERole.ROLE_ADMIN);

			roleRepository.save(r);
			roleRepository.save(r1);
			roleRepository.save(r2);

			Set<Role> roles = new HashSet<>();
			roles.add(r);
			roles.add(r1);
			roles.add(r2);


			String pass = "jasio";
			User admin = new User("admin", "age002@gmail.com", encoder.encode(pass), roles);
			userRepository.save(admin);

		};
	}

}
