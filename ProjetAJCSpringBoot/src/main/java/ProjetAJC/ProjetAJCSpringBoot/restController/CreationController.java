package ProjetAJC.ProjetAJCSpringBoot.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetAJC.ProjetAJCSpringBoot.entity.Compte;
import ProjetAJC.ProjetAJCSpringBoot.entity.CompteRole;
import ProjetAJC.ProjetAJCSpringBoot.entity.Role;
import ProjetAJC.ProjetAJCSpringBoot.exception.UserInvalidException;
import ProjetAJC.ProjetAJCSpringBoot.repository.CompteRepository;
import ProjetAJC.ProjetAJCSpringBoot.repository.CompteRoleRepository;


@RestController
@RequestMapping("/api/creation")
@CrossOrigin(origins="*")
public class CreationController {
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private CompteRoleRepository compteRoleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping({ "", "/" })
	public ResponseEntity<Void> ajoutUser(@Valid @RequestBody Compte compte, BindingResult br) {
		if (br.hasErrors()) {
			throw new UserInvalidException();
		}
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		compteRepository.save(compte);
		compteRoleRepository.save(new CompteRole(compte, Role.ROLE_EMPLOYE));
		compteRoleRepository.save(new CompteRole(compte, Role.ROLE_MANAGER));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{mail}")
	public boolean mailDispo(@PathVariable("mail") String mail) {
		return compteRepository.findById(mail).isPresent();
	}
}
