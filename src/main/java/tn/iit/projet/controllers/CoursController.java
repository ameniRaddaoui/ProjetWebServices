package tn.iit.projet.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.iit.projet.dao.CoursRepositorie;
import tn.iit.projet.dao.EnsignantRepositorie;
import tn.iit.projet.dao.GroupeRepositorie;
import tn.iit.projet.dao.SalleRepositorie;
import tn.iit.projet.dao.SeanceRepositorie;
import tn.iit.projet.entities.Cours;


@Controller
@RequestMapping("admin/cours")
public class CoursController {
	
	@Autowired
	private CoursRepositorie courDao;	
	
	@Autowired
	private EnsignantRepositorie enseignantDao;
	
	@Autowired
	private GroupeRepositorie groupeDao;
	
	@Autowired
	private SalleRepositorie salleDao;	
	
	@Autowired
	private SeanceRepositorie seanceDao;	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getCours() {
		
		ModelAndView model = new ModelAndView("cours/cours");
		model.addObject("coursList", courDao.findAll());
		return model;
	}
	

	
	@RequestMapping(value = "createOrUpdateCour", method = RequestMethod.GET)
	public ModelAndView createOrUpdateCour1(@RequestParam (required = false) Long idCour) {
		
		ModelAndView model = new ModelAndView("cours/form");
		model.addObject("enseignants", enseignantDao.findAll()); 
		model.addObject("groupes", groupeDao.findAll()); 
		model.addObject("salles", salleDao.findAll()); 
		model.addObject("seances", seanceDao.findAll()); 
		if(idCour != null){			
			model.addObject("coursInfo", courDao.findOne(idCour)); 
		}
		
		return model;			
	}
	

	@RequestMapping(value = "addoredit", method = RequestMethod.POST)
	public RedirectView createOrUpdateCour(@RequestParam(required= false) Long idCour, @RequestParam Long enseignant, @RequestParam Long groupe,
			@RequestParam Long salle, @RequestParam Long seance, HttpServletRequest request) {
		
		Cours cours;
		
		if(idCour == null){
			
			cours = new Cours();
			
			cours.setEnseignant(enseignantDao.getOne(enseignant));
			cours.setGroupe(groupeDao.getOne(groupe));
			cours.setSalle(salleDao.getOne(salle));
			cours.setSeance(seanceDao.getOne(seance));
			
			courDao.save(cours);	
		}
		else{
			
			cours = courDao.getOne(idCour);

			cours.setEnseignant(enseignantDao.getOne(enseignant));
			cours.setGroupe(groupeDao.getOne(groupe));
			cours.setSalle(salleDao.getOne(salle));
			cours.setSeance(seanceDao.getOne(seance));
			
			courDao.save(cours);	
		}
	
		return new RedirectView("list");
	}


	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public RedirectView removeCour(@RequestParam Long idCour) {
		courDao.delete(idCour);
		return new RedirectView("list");
	}
}
