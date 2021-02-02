package ProjetAJC.ProjetAJCSpringBoot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ProjetAJC.ProjetAJCSpringBoot.repository.CompteRepository;
import ProjetAJC.ProjetAJCSpringBoot.repository.CompteRoleRepository;


@Service
public class ConsoleService implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(ConsoleService.class);

	@Autowired
	CompteRepository compteRepo;
	@Autowired
	CompteRoleRepository compteRoleRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

//		User u = new User();
//		u.setLogin("olivier");
//		u.setPassword(passwordEncoder.encode("olivier"));
//		userRepo.save(u);
//
//		userRoleRepo.save(new UserRole(u, Role.ROLE_ADMIN));
//		userRoleRepo.save(new UserRole(u, Role.ROLE_USER));
//
//		u = new User();
//		u.setLogin("toto");
//		u.setPassword(passwordEncoder.encode("toto"));
//		userRepo.save(u);
//
//		userRoleRepo.save(new UserRole(u, Role.ROLE_USER));

	}

}
