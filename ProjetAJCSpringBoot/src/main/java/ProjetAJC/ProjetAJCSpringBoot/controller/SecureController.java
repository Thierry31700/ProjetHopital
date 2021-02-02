package ProjetAJC.ProjetAJCSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/secure")
@Controller
public class SecureController {

	@GetMapping("/home")
	public String home() {
		return "secure/home";
	}
}
