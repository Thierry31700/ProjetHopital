package ProjetAJC.ProjetAJCSpringBoot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/home")
public class AllController {

	Logger log = LoggerFactory.getLogger(AllController.class);
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String admin() {
		return "admin/home";
	}
	@PreAuthorize("hasRole('ADMIN'&&'MANAGER')")
	@GetMapping("/homemgr")
	public String homemgr() {
		return "manager/homemgr";
	}
	
}
