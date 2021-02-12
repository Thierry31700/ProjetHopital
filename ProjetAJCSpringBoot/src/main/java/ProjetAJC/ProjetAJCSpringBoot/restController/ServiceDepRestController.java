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

import ProjetAJC.ProjetAJCSpringBoot.entity.ServiceDep;
import ProjetAJC.ProjetAJCSpringBoot.entity.Vue;
import ProjetAJC.ProjetAJCSpringBoot.exception.ServiceDepInvalidException;
import ProjetAJC.ProjetAJCSpringBoot.exception.ServiceDepNotFoundException;
import ProjetAJC.ProjetAJCSpringBoot.service.ServiceDepService;

@RestController
@RequestMapping("/api/service")
@CrossOrigin(origins="*")
public class ServiceDepRestController {

	@Autowired
	private ServiceDepService serviceDepService;

	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public List<ServiceDep> getAllSercvieDep() {
		return serviceDepService.allservice();
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<ServiceDep> addServiceDep(@Valid @RequestBody ServiceDep s, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new ServiceDepInvalidException();
		}
		serviceDepService.creation(s);
		URI uri = uCB.path("/api/service/{id}").buildAndExpand(s.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<ServiceDep>(s, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ServiceDep findById(@PathVariable("id") Integer id) {
		ServiceDep s = serviceDepService.findById(id);
		if (s.getId() != null) {
			return s;
		}
		throw new ServiceDepNotFoundException();
	}

	@PutMapping("/{id}")
	public ServiceDep update(@Valid @RequestBody ServiceDep s, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new ServiceDepInvalidException();
		}
		ServiceDep serviceDepEnBase = serviceDepService.findById(id);
		if (serviceDepEnBase.getId() == null) {
			throw new ServiceDepNotFoundException();
		}
		serviceDepEnBase.setLibelle(s.getLibelle());
		
		serviceDepService.save(serviceDepEnBase);
		return serviceDepEnBase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		ServiceDep serviceDepEnBase = serviceDepService.findById(id);
		if (serviceDepEnBase.getId() == null) {
			throw new ServiceDepNotFoundException();
		}
		serviceDepService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//	@GetMapping("/test")
//	@JsonView(Vue.Common.class)
//	public ServiceDep test() {
//		return testPrivate();
//	}
//
//	@GetMapping("/test/Adresse")
//	@JsonView(Vue.ServiceDepWithAdresse.class)
//	public ServiceDep test2() {
//		return testPrivate();
//	}
//
//	private ServiceDep testPrivate() {
//		Adresse a = new Adresse();
//		a.setRue("rue aaa");
//		ServiceDep p = new ServiceDep("aa", "pp");
//		p.setAdresse(a);
//		return p;
//	}

}

