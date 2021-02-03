package ProjetAJC.ProjetAJCSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/accueil")
	public String accueil() {
		return "accueil";
	}

	@GetMapping("/bye")
	public String bye() {
		return "bye";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}

}
