package ProjetAJC.ProjetAJCSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ProjetAJC.ProjetAJCSpringBoot.entity.Conge;
import ProjetAJC.ProjetAJCSpringBoot.repository.CongeRepository;
import ProjetAJC.ProjetAJCSpringBoot.service.CompteDetails;
import ProjetAJC.ProjetAJCSpringBoot.service.CongeService;

@Controller
@RequestMapping("/spring/conge")
public class CongeController {
	@Autowired
	private CongeService congeService;
	@Autowired
	private CongeRepository congeRepo;

	@GetMapping("")
	public ModelAndView list(Authentication authent) {
		 CompteDetails comptdetails= (CompteDetails)authent.getPrincipal();
		return new ModelAndView("conge/list", "conges", congeRepo.findAll());

	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam Integer id) {
		congeService.delete(id);
		return new ModelAndView("redirect:/spring/conge");
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("conge") Conge conge, BindingResult br) {
		if (br.hasErrors()) {
			System.out.println("error");
			return goEdit(conge);
		}
		if (conge.getId() == null) {
			congeService.creationConge(conge);
			;
		} else {
			congeService.modification(conge);
		}

		return new ModelAndView("redirect:/spring/conge");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam Integer id) {
		return goEdit(congeService.find(id));
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goEdit(new Conge());
	}

	private ModelAndView goEdit(Conge conge) {
		ModelAndView modelAndView = new ModelAndView("conge/edit", "conge", conge);
		return modelAndView;
	}

}
