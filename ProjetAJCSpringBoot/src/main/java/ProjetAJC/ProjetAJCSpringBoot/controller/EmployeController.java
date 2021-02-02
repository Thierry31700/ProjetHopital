package ProjetAJC.ProjetAJCSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ProjetAJC.ProjetAJCSpringBoot.entity.Employe;
import ProjetAJC.ProjetAJCSpringBoot.service.EmployeService;
import ProjetAJC.ProjetAJCSpringBoot.service.ServiceDepService;




@Controller
@RequestMapping("/employe")
public class EmployeController {
	
	@Autowired
	private EmployeService employeService;
	
	@Autowired
	private ServiceDepService serviceDepService;
	
	
	@GetMapping({ "", "/" })
	public ModelAndView list() {
		return new ModelAndView("employe/list", "employes", employeService.allEmploye());
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id") Integer id) {
		 employeService.delete(id);
		return new ModelAndView("redirect:/employe");
	}	

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") Integer id) {
		return goForm( employeService.findbyId(id));
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goForm(new Employe());
	}

	private ModelAndView goForm(Employe employe) {
		ModelAndView modelAndView = new ModelAndView("employe/edit");
		modelAndView.addObject("employe", employe);
		modelAndView.addObject("service",serviceDepService.allservice());
		return modelAndView;
	}
	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("employe") Employe employe, BindingResult br) {

		if (employe.getManager().getId() == null) {
			employe.setManager(null);
		}
		if (employe.getService() != null && employe.getService().getId() == null) {
			employe.setService(null);
		}
		if (br.hasErrors()) {
			return goForm(employe);
		}
		if (employe.getId() == null) {
			employeService.save(employe);
		} else {
			employeService.save(employe);
		}
		return new ModelAndView("redirect:/employe");
	}
	

}
