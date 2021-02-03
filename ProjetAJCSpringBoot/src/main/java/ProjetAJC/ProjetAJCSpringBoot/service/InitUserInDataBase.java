package ProjetAJC.ProjetAJCSpringBoot.service;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ProjetAJC.ProjetAJCSpringBoot.entity.Compte;
import ProjetAJC.ProjetAJCSpringBoot.entity.CompteRole;
import ProjetAJC.ProjetAJCSpringBoot.entity.Conge;
import ProjetAJC.ProjetAJCSpringBoot.entity.Employe;
import ProjetAJC.ProjetAJCSpringBoot.entity.Role;
import ProjetAJC.ProjetAJCSpringBoot.entity.ServiceDep;
import ProjetAJC.ProjetAJCSpringBoot.entity.TypeConge;
import ProjetAJC.ProjetAJCSpringBoot.repository.CompteRepository;
import ProjetAJC.ProjetAJCSpringBoot.repository.CompteRoleRepository;
import ProjetAJC.ProjetAJCSpringBoot.repository.CongeRepository;
import ProjetAJC.ProjetAJCSpringBoot.repository.EmployeRepository;
import ProjetAJC.ProjetAJCSpringBoot.repository.ServiceDepRepository;

@Service
public class InitUserInDataBase implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncorder;
	@Autowired
	private CompteRepository compteRepo;

	@Autowired
	private CompteRoleRepository compteRoleRepo;

	@Autowired
	private ServiceDepRepository serviceRepo;

	@Autowired
	private EmployeRepository employeRepo;

	@Autowired
	private CongeRepository congeRepo;


	@Override
	public void run(String... args) throws Exception {
//		Compte u = new Compte();
//		u.setMail("toto@mail");
//		u.setPassword(passwordEncorder.encode("toto"));
//		compteRepo.save(u);
//
//		compteRoleRepo.save(new CompteRole(u, Role.ROLE_ADMIN));
//
//		Compte u1 = new Compte();
//		u1.setMail("fifi@mail");
//		u1.setPassword(passwordEncorder.encode("fifi"));
//		compteRepo.save(u1);
//
//		compteRoleRepo.save(new CompteRole(u1, Role.ROLE_MANAGER));
//		compteRoleRepo.save(new CompteRole(u1, Role.ROLE_EMPLOYE));
//
//
//		Compte u2 = new Compte();
//		u2.setMail("riri@mail");
//		u2.setPassword(passwordEncorder.encode("riri"));
//		compteRepo.save(u2);
//
//		compteRoleRepo.save(new CompteRole(u2, Role.ROLE_EMPLOYE));
//
//		ServiceDep s=new ServiceDep();
//		s.setLibelle("Compta");
//		serviceRepo.save(s);
//
//		ServiceDep s1=new ServiceDep();
//		s1.setLibelle("Administration");
//		serviceRepo.save(s1);
//
//		ServiceDep s2=new ServiceDep();
//		s2.setLibelle("Developpeur");
//		serviceRepo.save(s2);
//
//		Employe e = new Employe();
//		e.setNom("duck");
//		e.setPrenom("fifi");
//		e.setService(s1);
//		e.setCompte(u1);
//		employeRepo.save(e);
//		
//		Employe e1 = new Employe();
//		e1.setNom("canard");
//		e1.setPrenom("riri");
//		e1.setService(s);
//		e1.setCompte(u2);
//		employeRepo.save(e1);
//		
//		Employe e2 = new Employe();
//		e2.setNom("toto");
//		e2.setPrenom("Donald");
//		e2.setService(s2);
//		e2.setCompte(u);
//		employeRepo.save(e2);
//		
//		
//		Conge c = new Conge();
//		c.setEmploye(e);
//		c.setTypeConge(TypeConge.CP);
//		c.setDateDebut(LocalDate.of(2021, 01, 18));
//		c.setDateFin(LocalDate.of(2021, 01, 20));
//		c.setMotif("Vacances aux caraibes");
//		congeRepo.save(c);
//		
//		
//		Conge c1 = new Conge();
//		c1.setEmploye(e1);
//		c1.setTypeConge(TypeConge.CP);
//		c1.setDateDebut(LocalDate.of(2021, 03, 18));
//		c1.setDateFin(LocalDate.of(2021, 03, 30));
//		c1.setMotif("Vacances en Egypte");
//		congeRepo.save(c1);
//		
//		Conge c2 = new Conge();
//		c2.setEmploye(e);
//		c2.setTypeConge(TypeConge.CJ);
//		c2.setDateDebut(LocalDate.of(2021, 02, 18));
//		c2.setDateFin(LocalDate.of(2021, 02, 28));
//		c2.setMotif("Vacances en Australie");
//		congeRepo.save(c2);
//		
//		
//		Conge c3 = new Conge();
//		c3.setEmploye(e1);
//		c3.setTypeConge(TypeConge.CA);
//		c3.setDateDebut(LocalDate.of(2021, 11, 01));
//		c3.setDateFin(LocalDate.of(2021, 11, 22));
//		c3.setMotif("Vacances au cambodge");
//		congeRepo.save(c3);
	}
}
