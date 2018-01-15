package tn.iit.projet.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.iit.projet.dao.GroupeRepositorie;
import tn.iit.projet.entities.Groupe;


@Controller
@RequestMapping("admin/groupe")
public class GroupeController {
	
	@Autowired
	private GroupeRepositorie groupeDao;	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getGroupes() {
		
		ModelAndView model = new ModelAndView("groupe/groupes");
		model.addObject("groupeList", groupeDao.findAll());
		return model;
	}
	

	
	@RequestMapping(value = "createOrUpdateGroupe", method = RequestMethod.GET)
	public ModelAndView createOrUpdateGroupe1(@RequestParam (required = false) Long idGroupe) {
		
		ModelAndView model = new ModelAndView("groupe/form");
		
		if(idGroupe != null){			
			model.addObject("groupeInfo", groupeDao.getOne(idGroupe)); 
		}
		
		return model;			
	}
	

	@RequestMapping(value = "addoredit", method = RequestMethod.POST)
	public RedirectView createOrUpdateGroupe(@RequestParam(required= false) Long idGroupe, @RequestParam String libelle, @RequestParam String specialite, @RequestParam int niveau,
			HttpServletRequest request) {
		
		Groupe groupe;
		
		if(idGroupe == null){
			
			groupe = new Groupe();
			
			groupe.setLibelle(libelle);
			groupe.setSpecialite(specialite);
			groupe.setNiveau(niveau);
			
			groupeDao.save(groupe);	
		}
		else{
			
			groupe = groupeDao.getOne(idGroupe);

			groupe.setLibelle(libelle);
			groupe.setSpecialite(specialite);
			groupe.setNiveau(niveau);
			
			groupeDao.save(groupe);	
		}
	
		return new RedirectView("list");
	}


	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public RedirectView removeGroupe(@RequestParam Long idGroupe) {
		groupeDao.delete(idGroupe);
		return new RedirectView("list");
	}
}
