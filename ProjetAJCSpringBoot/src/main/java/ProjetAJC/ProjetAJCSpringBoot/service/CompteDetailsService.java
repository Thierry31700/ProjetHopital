package ProjetAJC.ProjetAJCSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ProjetAJC.ProjetAJCSpringBoot.entity.Compte;
import ProjetAJC.ProjetAJCSpringBoot.repository.CompteRepository;

@Service
public class CompteDetailsService implements UserDetailsService {

	@Autowired
	private CompteRepository compterepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Compte> opt = compterepo.findByMailWithRoles(username);
		if (opt.isPresent()) {
			return new CompteDetails(opt.get());
		}
		throw new UsernameNotFoundException("username inconnu");
	}
	public void creationCompte(Compte c) {
		if (c.getMail() != null && !c.getMail().isEmpty() && c.getPassword() != null && !c.getPassword().isEmpty()) {
			compterepo.save(c);
		} else {
			System.out.println("Le compte n'a pas toute les infos obligatoires");
		}
	}
	public void creationCompte(String mail, String password) {
		creationCompte(new Compte(mail,password));
	}

	public List<Compte> allCompte() {
		return compterepo.findAll();
	}
	
	public void delete(Compte c) {
		compterepo.delete(c);
	}

	public void delete(String mail) {
		compterepo.deleteById(mail);
	}

	public Compte save(Compte c) {
		return compterepo.save(c);
	}

	public Compte findbyId(String mail) {
		Optional<Compte> opt = compterepo.findById(mail);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Compte();
	}
	
	}

