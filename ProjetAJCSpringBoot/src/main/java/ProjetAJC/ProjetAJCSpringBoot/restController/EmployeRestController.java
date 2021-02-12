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

import ProjetAJC.ProjetAJCSpringBoot.entity.Employe;
import ProjetAJC.ProjetAJCSpringBoot.exception.EmployeInvalidException;
import ProjetAJC.ProjetAJCSpringBoot.exception.EmployeNotFoundException;
import ProjetAJC.ProjetAJCSpringBoot.service.EmployeService;

@RestController
@RequestMapping("/api/Employe")
@CrossOrigin(origins="*")
public class EmployeRestController {

	@Autowired
	private EmployeService EmployeService;

	@GetMapping({ "", "/" })
	public List<Employe> getAllEmploye() {
		return EmployeService.allEmploye();
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Employe> addEmploye(@Valid @RequestBody Employe p, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new EmployeInvalidException();
		}
		EmployeService.creationEmploye(p);
		URI uri = uCB.path("/api/Employe/{id}").buildAndExpand(p.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Employe>(p, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Employe findById(@PathVariable("id") Integer id) {
		Employe p = EmployeService.findbyId(id);
		if (p.getId() != null) {
			return p;
		}
		throw new EmployeNotFoundException();
	}

	@PutMapping("/{id}")
	public Employe update(@Valid @RequestBody Employe p, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new EmployeInvalidException();
		}
		Employe EmployeEnBase = EmployeService.findbyId(id);
		if (EmployeEnBase.getId() == null) {
			throw new EmployeNotFoundException();
		}
		EmployeEnBase.setPrenom(p.getPrenom());
		EmployeEnBase.setNom(p.getNom());
		EmployeService.save(EmployeEnBase);
		return EmployeEnBase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Employe EmployeEnBase = EmployeService.findbyId(id);
		if (EmployeEnBase.getId() == null) {
			throw new EmployeNotFoundException();
		}
		EmployeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


}
