package tn.iit.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.iit.projet.dao.EmployeRepository;
import tn.iit.projet.entities.Employe;

@Controller
public class indexController {
	
	
	
	@Autowired
	private EmployeRepository employeRepo;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "index")
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();

		Employe p = employeRepo.getEmployeByLogin(login);
		
		
		if (p.getRole().equals("ROLE_ADMIN")) {
			
			return "redirect:admin/employe/list";
		} else {
			return "redirect:user/departement/list";
		}

	}

	
	@RequestMapping(value = "403")
	public String NotAutho() {
		return "403";

}
	
}
