package ProjetAJC.ProjetAJCSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/bye")
	public String bye() {
		return "bye";
	}

	@GetMapping("")
	public String home() {
		return "home";
	}
}
