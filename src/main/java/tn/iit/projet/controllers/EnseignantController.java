package tn.iit.projet.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.iit.projet.dao.EnsignantRepositorie;
import tn.iit.projet.entities.Enseignant;

@Controller
@RequestMapping("admin/enseignant")
public class EnseignantController {
	
	@Autowired
	private EnsignantRepositorie enseignantDao;	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getEnseignants() {
		
		ModelAndView model = new ModelAndView("enseignant/enseignants");
		model.addObject("enseignantList", enseignantDao.findAll());
		return model;
	}
	

	
	@RequestMapping(value = "createOrUpdateEnseignant", method = RequestMethod.GET)
	public ModelAndView createOrUpdateEnseignant1(@RequestParam (required = false) Long idEnseignant) {
		
		ModelAndView model = new ModelAndView("enseignant/form");
		
		if(idEnseignant != null){			
			model.addObject("enseignantInfo", enseignantDao.getOne(idEnseignant)); 
		}
		
		return model;			
	}
	

	@RequestMapping(value = "addoredit", method = RequestMethod.POST)
	public RedirectView createOrUpdateEnseignant(@RequestParam(required= false) Long idEnseignant, @RequestParam String nom, @RequestParam String prenom, @RequestParam String tel,
		    @RequestParam String adresse, @RequestParam String grade, @RequestParam String email, HttpServletRequest request) {
		
		Enseignant enseignant;
		
		if(idEnseignant == null){
			
			enseignant = new Enseignant();
			enseignant.setNom(nom);
			enseignant.setPrenom(prenom);
			enseignant.setTel(tel);
			enseignant.setAdresse(adresse);
			enseignant.setGrade(grade);
			enseignant.setEmail(email);
			enseignantDao.save(enseignant);	
		}
		else{
			
			enseignant = enseignantDao.getOne(idEnseignant);
			enseignant.setNom(nom);
			enseignant.setPrenom(prenom);
			enseignant.setTel(tel);
			enseignant.setAdresse(adresse);
			enseignant.setGrade(grade);
			enseignant.setEmail(email);
			enseignantDao.save(enseignant);	
		}
	
		return new RedirectView("list");
	}


	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public RedirectView removeEnseignant(@RequestParam Long idEnseignant) {
		enseignantDao.delete(idEnseignant);
		return new RedirectView("list");
	}
}
