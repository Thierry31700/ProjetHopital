package ProjetAJC.ProjetAJCSpringBoot.service;

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
	}

