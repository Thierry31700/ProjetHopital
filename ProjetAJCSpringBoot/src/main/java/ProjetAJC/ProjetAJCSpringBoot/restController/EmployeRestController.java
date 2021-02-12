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

import ProjetAJC.ProjetAJCSpringBoot.entity.Employe;
import ProjetAJC.ProjetAJCSpringBoot.entity.Vue;
import ProjetAJC.ProjetAJCSpringBoot.exception.EmployeInvalidException;
import ProjetAJC.ProjetAJCSpringBoot.exception.EmployeNotFoundException;
import ProjetAJC.ProjetAJCSpringBoot.service.EmployeService;


@RestController
@RequestMapping("/api/employe")
@CrossOrigin(origins="*")
public class EmployeRestController {

	@Autowired
	private EmployeService employeService;

	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public List<Employe> getAllEmploye() {
		return employeService.allEmploye();
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Employe> addEmploye(@Valid @RequestBody Employe e, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new EmployeInvalidException();
		}
		employeService.creationEmploye(e);
		URI uri = uCB.path("/api/Employe/{id}").buildAndExpand(e.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Employe>(e, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Employe findById(@PathVariable("id") Integer id) {
		Employe e = employeService.findbyId(id);
		if (e.getId() != null) {
			return e;
		}
		throw new EmployeNotFoundException();
	}

	@PutMapping("/{id}")
	public Employe update(@Valid @RequestBody Employe e, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new EmployeInvalidException();
		}
		Employe EmployeEnBase = employeService.findbyId(id);
		if (EmployeEnBase.getId() == null) {
			throw new EmployeNotFoundException();
		}
		EmployeEnBase.setPrenom(e.getPrenom());
		EmployeEnBase.setNom(e.getNom());
		employeService.save(EmployeEnBase);
		return EmployeEnBase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Employe EmployeEnBase = employeService.findbyId(id);
		if (EmployeEnBase.getId() == null) {
			throw new EmployeNotFoundException();
		}
		employeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
