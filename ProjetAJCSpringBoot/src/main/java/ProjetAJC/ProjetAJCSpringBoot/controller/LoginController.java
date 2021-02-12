package ProjetAJC.ProjetAJCSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/spring/accueil")
	public String accueil() {
		return "accueil";
	}

	@GetMapping("/spring/bye")
	public String bye() {
		return "bye";
	}
	@GetMapping("/spring/home")
	public String home() {
		return "home";
	}

}
