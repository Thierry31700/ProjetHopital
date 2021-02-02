package ProjetAJC.ProjetAJCSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetAJC.ProjetAJCSpringBoot.entity.Employe;
import ProjetAJC.ProjetAJCSpringBoot.entity.ServiceDep;
import ProjetAJC.ProjetAJCSpringBoot.repository.EmployeRepository;


@Service
public class EmployeService {

	@Autowired
	private EmployeRepository employeRepo;
	
	
	public void creationEmploye(Employe e) {
		if (e.getPrenom() != null && !e.getPrenom().isEmpty() && e.getNom() != null && !e.getNom().isEmpty()) {
			employeRepo.save(e);
		} else {
			System.out.println("l'Employe n'a pas toute les infos obligatoires");
		}
	}

	public void creationEmploye(String prenom, String nom) {
		creationEmploye(new Employe(nom,prenom));
	}

	public List<Employe> allEmploye() {
		return employeRepo.findAll();
	}
	
	public void delete(Employe e) {
		employeRepo.delete(e);
	}

	public void delete(Integer id) {
		employeRepo.deleteById(id);
	}

	public Employe save(Employe e) {
		return employeRepo.save(e);
	}

	public Employe findbyId(Integer id) {
		Optional<Employe> opt = employeRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Employe();
	}
	
}
