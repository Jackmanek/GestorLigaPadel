package com.ligapadel.GestorLigaPadel;

import com.ligapadel.GestorLigaPadel.entity.*;
import com.ligapadel.GestorLigaPadel.repository.PlayerRepository;
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
	public ApplicationRunner configure(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder, PlayerRepository playerRepository) {
		return env -> {

			String pass = "quieroser12";
			User user0 = new User("Carlos", "carlos@gmail.com", encoder.encode(pass));
			User user1 = new User("Jasmany", "jasmany@gmail.com", encoder.encode(pass));
			User user2 = new User("Oscar", "coscar@gmail.com", encoder.encode(pass));
			User user3 = new User("Alberto", "alberto@gmail.com", encoder.encode(pass));
			User user4 = new User("Luis", "luis@gmail.com", encoder.encode(pass));
			User user5 = new User("Joseba", "joseba@gmail.com", encoder.encode(pass));
			User user6 = new User("Mikel", "mikel@gmail.com", encoder.encode(pass));
			User user7 = new User("Sofia", "sofia@gmail.com", encoder.encode(pass));
			User user8 = new User("Antonia", "antonia@gmail.com", encoder.encode(pass));
			User user9 = new User("Ohiana", "ohiana@gmail.com", encoder.encode(pass));
			User user10 = new User("Maria", "maria@gmail.com", encoder.encode(pass));
			User user11 = new User("Pedro", "pedro@gmail.com", encoder.encode(pass));
			User user12 = new User("Jon", "jon@gmail.com", encoder.encode(pass));
			User user13 = new User("Adrian", "adrian@gmail.com", encoder.encode(pass));


			userRepository.save(user0);
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			userRepository.save(user4);
			userRepository.save(user5);
			userRepository.save(user6);
			userRepository.save(user7);
			userRepository.save(user8);
			userRepository.save(user9);
			userRepository.save(user10);
			userRepository.save(user11);
			userRepository.save(user12);
			userRepository.save(user13);






			Player player0 = new Player(user0,"Carlos" ,"Palomares" ,51, "Masculino"," ", new DataContact("carlos@gmail.com", "670885344"));
			Player player1 = new Player(user1,"Jasmany", "Zambrano", 37, "Masculino", "", new DataContact("carlos@hotmail.com","123456789"));
			Player player2 = new Player(user2,"Oscar", "Colmenero", 38, "Masculino", "", new DataContact("carlos@hotmail.com","123456789"));
			Player player3 = new Player(user3, "Alberto", "Bueno", 52, "Masculino", "", new DataContact("carlos@hotmail.com","123456789"));
			Player player4 = new Player(user4,"Luis", "Trejo", 52, "Masculino", "", new DataContact("carlos@hotmail.com","123456789"));
			Player player5 = new Player(user5,"Joseba", "Sanchez", 25, "Masculino", "", new DataContact("carlos@hotmail.com","123456789"));
			Player player6 = new Player(user6,"Mikel", "Virceda", 38, "Masculino", "", new DataContact("carlos@hotmail.com","123456789"));
			Player player7 = new Player(user7,"Sofia", "Araujo", 24, "Femenino", "", new DataContact("carlos@hotmail.com","123456789"));
			Player player8 = new Player(user8,"Antonia", "Tapia", 29, "Femenino", "", new DataContact("carlos@hotmail.com","123456789"));
			Player player9 = new Player(user9,"Ohiana", "Gordobil", 24, "Femenino", "", new DataContact("carlos@hotmail.com","123456789"));
			Player player10 = new Player(user10, "Maria", "Arrieta", 31, "Femenino", "", new DataContact("carlos@hotmail.com","123456789"));
			Player player11 = new Player(user11,"Pedro", "Caryon", 32, "Masculino", "", new DataContact("carlos@hotmail.com","123456789"));
			Player player12 = new Player(user12,"Jon", "Baryolo", 27, "Masculino", "", new DataContact("carlos@hotmail.com","123456789"));
			Player player13 = new Player(user13, "Adrian", "Cohello", 20, "Masculino", "", new DataContact("carlos@hotmail.com","123456789"));

			playerRepository.save(player0);
			playerRepository.save(player1);
			playerRepository.save(player2);
			playerRepository.save(player3);
			playerRepository.save(player4);
			playerRepository.save(player5);
			playerRepository.save(player6);
			playerRepository.save(player7);
			playerRepository.save(player8);
			playerRepository.save(player9);
			playerRepository.save(player10);
			playerRepository.save(player11);
			playerRepository.save(player12);
			playerRepository.save(player13);






			User admin = new User("admin", "age002@gmail.com", encoder.encode(pass));
			userRepository.save(admin);

		};
	}

}
