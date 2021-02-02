package ProjetAJC.ProjetAJCSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetAJC.ProjetAJCSpringBoot.entity.ServiceDep;
import ProjetAJC.ProjetAJCSpringBoot.repository.ServiceDepRepository;


@Service
public class ServiceDepService {

	
	@Autowired
	private ServiceDepRepository servicerepo;
	
	public void creation(ServiceDep service) {
		servicerepo.save(service);
	}
	
	public void modification(ServiceDep service) {
		servicerepo.save(service);
	}

	public List<ServiceDep> allservice() {
		return servicerepo.findAll();
	}

	public void delete(ServiceDep s) {
		servicerepo.delete(s);
	}

	public void delete(Integer id) {
		servicerepo.deleteById(id);
	}

	public ServiceDep findById(Integer id) {
		Optional<ServiceDep> opt = servicerepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new ServiceDep();
	}
	public ServiceDep save(ServiceDep s) {
		return servicerepo.save(s);
	}

	
	
}
