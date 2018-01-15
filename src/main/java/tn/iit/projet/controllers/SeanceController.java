package tn.iit.projet.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.iit.projet.dao.SeanceRepositorie;
import tn.iit.projet.entities.Seance;


@Controller
@RequestMapping("admin/seance")
public class SeanceController {
	
	@Autowired
	private SeanceRepositorie seanceDao;	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getSeances() {
		
		ModelAndView model = new ModelAndView("seance/seances");
		model.addObject("seanceList", seanceDao.findAll());
		return model;
	}
	

	
	@RequestMapping(value = "createOrUpdateSeance", method = RequestMethod.GET)
	public ModelAndView createOrUpdateSeance1(@RequestParam (required = false) Long idSeance) {
		
		ModelAndView model = new ModelAndView("seance/form");
		
		if(idSeance != null){			
			model.addObject("seanceInfo", seanceDao.getOne(idSeance)); 
		}
		
		return model;			
	}
	

	@RequestMapping(value = "addoredit", method = RequestMethod.POST)
	public RedirectView createOrUpdateSeance(@RequestParam(required= false) Long idSeance, @RequestParam String libelle, @RequestParam String heure_debut, @RequestParam String heure_fin,
			HttpServletRequest request) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Seance seance;
		
		if(idSeance == null){
			
			seance = new Seance();
			
			seance.setLibelle(libelle);
			try {
				seance.setHeure_debut(sdf.parse(heure_debut));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			try {
				seance.setHeure_fin(sdf.parse(heure_fin));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			seanceDao.save(seance);	
		}
		else{
			
			seance = seanceDao.getOne(idSeance);

			seance.setLibelle(libelle);
			try {
				seance.setHeure_debut(sdf.parse(heure_debut));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			try {
				seance.setHeure_fin(sdf.parse(heure_fin));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			seanceDao.save(seance);	
		}
	
		return new RedirectView("list");
	}


	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public RedirectView removeSeance(@RequestParam Long idSeance) {
		seanceDao.delete(idSeance);
		return new RedirectView("list");
	}
}
