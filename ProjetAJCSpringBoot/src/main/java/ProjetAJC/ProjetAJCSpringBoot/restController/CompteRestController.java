package ProjetAJC.ProjetAJCSpringBoot.restController;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetAJC.ProjetAJCSpringBoot.entity.Compte;
import ProjetAJC.ProjetAJCSpringBoot.entity.Vue;
import ProjetAJC.ProjetAJCSpringBoot.exception.EmployeNotFoundException;
import ProjetAJC.ProjetAJCSpringBoot.exception.UserInvalidException;
import ProjetAJC.ProjetAJCSpringBoot.service.CompteDetailsService;




@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins="*")
public class CompteRestController {

	@Autowired
	private CompteDetailsService compteService;
	
	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public List<Compte> getAllCompte() {
		return compteService.allCompte();
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Compte> addCompte(@Valid @RequestBody Compte c, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new UserInvalidException();
		}
		compteService.creationCompte(c);
		URI uri = uCB.path("/api/compte/{id}").buildAndExpand(c.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Compte>(c, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{mail}")
	@JsonView(Vue.Common.class)
	public Compte findById(@PathVariable("mail") String mail) {
		Compte c = compteService.findbyId(mail);
		if (c.getId() != null) {
			return c;
		}
		throw new UserInvalidException();
	}

	@PutMapping("/{mail}")
	@JsonView(Vue.Common.class)
	public Compte update(@Valid @RequestBody Compte c, BindingResult br, @PathVariable("mail") String mail) {
		if (br.hasErrors()) {
			throw new UserInvalidException();
		}
		Compte CompteEnBase = compteService.findbyId(mail);
		if (CompteEnBase.getId() == null) {
			throw new EmployeNotFoundException();
		}
		CompteEnBase.setMail(c.getMail());
		CompteEnBase.setPassword(c.getPassword());
		compteService.save(CompteEnBase);
		return CompteEnBase;
	}

	@DeleteMapping("/{mail}")
	public ResponseEntity<Void> delete(@PathVariable("mail") String mail) {
		Compte CompteEnBase = compteService.findbyId(mail);
		if (CompteEnBase.getId() == null) {
			throw new EmployeNotFoundException();
		}
		compteService.delete(mail);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
