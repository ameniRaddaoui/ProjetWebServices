package tn.iit.projet.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.iit.projet.dao.SalleRepositorie;
import tn.iit.projet.entities.Salle;


@Controller
@RequestMapping("admin/salle")
public class SalleController {
	
	@Autowired
	private SalleRepositorie salleDao;	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getSalles() {
		
		ModelAndView model = new ModelAndView("salle/salles");
		model.addObject("salleList", salleDao.findAll());
		return model;
	}
	

	
	@RequestMapping(value = "createOrUpdateSalle", method = RequestMethod.GET)
	public ModelAndView createOrUpdateSalle1(@RequestParam (required = false) Long idSalle) {
		
		ModelAndView model = new ModelAndView("salle/form");
		
		if(idSalle != null){			
			model.addObject("salleInfo", salleDao.getOne(idSalle)); 
		}
		
		return model;			
	}
	

	@RequestMapping(value = "addoredit", method = RequestMethod.POST)
	public RedirectView createOrUpdateSalle(@RequestParam(required= false) Long idSalle, @RequestParam String nom, @RequestParam int etage, @RequestParam int capacite,
			HttpServletRequest request) {
		
		Salle salle;
		
		if(idSalle == null){
			
			salle = new Salle();
			
			salle.setNom(nom);
			salle.setEtage(etage);
			salle.setCapacite(capacite);
			
			salleDao.save(salle);	
		}
		else{
			
			salle = salleDao.getOne(idSalle);

			salle.setNom(nom);
			salle.setEtage(etage);
			salle.setCapacite(capacite);
			
			salleDao.save(salle);	
		}
	
		return new RedirectView("list");
	}


	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public RedirectView removeSalle(@RequestParam Long idSalle) {
		salleDao.delete(idSalle);
		return new RedirectView("list");
	}
}
