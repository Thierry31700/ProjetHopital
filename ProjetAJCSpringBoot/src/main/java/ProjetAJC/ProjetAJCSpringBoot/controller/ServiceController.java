package ProjetAJC.ProjetAJCSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ProjetAJC.ProjetAJCSpringBoot.entity.ServiceDep;
import ProjetAJC.ProjetAJCSpringBoot.service.ServiceDepService;


@Controller
@RequestMapping("/spring/serviceDep")
public class ServiceController {

	@Autowired
	private ServiceDepService servicedepService;
	
	@GetMapping({ "", "/" })
	public ModelAndView list() {
		return new ModelAndView("ServiceDep/list", "ServiceDeps", servicedepService.allservice());
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id") Integer id) {
		servicedepService.delete(id);
		return new ModelAndView("redirect:/serviceDep");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") Integer id) {
		return goEdit(servicedepService.findById(id));
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goEdit(new ServiceDep());
	}

	private ModelAndView goEdit(ServiceDep serviceDep) {
		ModelAndView modelAndView = new ModelAndView("serviceDep/edit", "serviceDep", serviceDep);
		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView add(@Valid @ModelAttribute("serviceDep") ServiceDep serviceDep, BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(serviceDep);
		}
		if (serviceDep.getId() == null) {
			servicedepService.save(serviceDep);
		} else {
			servicedepService.save(serviceDep);
		}
		return new ModelAndView("redirect:/serviceDep");
	}
	
	
	
	
	
}
