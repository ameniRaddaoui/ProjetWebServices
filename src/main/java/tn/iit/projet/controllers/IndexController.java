package tn.iit.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.iit.projet.dao.UserDAO;
import tn.iit.projet.entities.User;

@Controller
public class IndexController {
	
	@Autowired
	private UserDAO userRepo;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "index")
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();

		User p = userRepo.findByNom(login);
		
		
		if (p.getRole().equals("ROLE_ADMIN")) {
			
			return "redirect:admin/enseignant/list";
		} else {
			return "redirect:user/acceuilAgent/list";
		}

	}

	
	@RequestMapping(value = "403")
	public String NotAutho() {
		return "403";

}
	
}
