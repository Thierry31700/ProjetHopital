package ProjetAJC.ProjetAJCSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetAJC.ProjetAJCSpringBoot.entity.Conge;
import ProjetAJC.ProjetAJCSpringBoot.repository.CongeRepository;

@Service
public class CongeService {

	@Autowired
	private CongeRepository congeRepo;


	public void creationConge(Conge conge) {
		congeRepo.save(conge);
	}

	public void modification(Conge conge) {
		congeRepo.save(conge);
	}
	

	public List<Conge> allConge() {
		return congeRepo.findAll();
	}

	public void delete(Conge c) {
		congeRepo.delete(c);
	}

	public void delete(Integer id) {
		congeRepo.deleteById(id);
	}

	public Conge find(Integer id) {
		Optional<Conge> opt = congeRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Conge();
	}
	public Conge save(Conge c) {
		return congeRepo.save(c);
	}





}
