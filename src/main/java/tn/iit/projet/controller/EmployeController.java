package tn.iit.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.iit.projet.dao.DepartementRepository;
import tn.iit.projet.dao.EmployeRepository;
import tn.iit.projet.entities.Employe;

@Controller
@RequestMapping("admin/employe")
public class EmployeController {

	@Autowired
	private DepartementRepository departementDao;
	@Autowired
	private EmployeRepository employeDao;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getEmployes() {

		ModelAndView model = new ModelAndView("employe/employes");
		
		model.addObject("employeList", employeDao.findAll());
		model.addObject("departementList", departementDao.findAll());

		return model;
	}

	
	@RequestMapping(value = "createOrUpdateEmploye", method = RequestMethod.GET)
	public ModelAndView createOrUpdateEmploye1(@RequestParam(required = false) Long idEmploye) {

		ModelAndView model = new ModelAndView("employe/form");

		if (idEmploye!= null) {
			model.addObject("employeInfo", employeDao.findOne(idEmploye));
		}
		model.addObject("employeList", employeDao.findAll());
		model.addObject("departementList", departementDao.findAll());
		return model;
	}

	@RequestMapping(value = "addoredit", method = RequestMethod.POST)
	public RedirectView createOrUpdateEmploye(@RequestParam(required = false) Long idEmploye,
			@RequestParam String firstName , @RequestParam String sexe ,@RequestParam String lastName ,
			@RequestParam String adresse ,@RequestParam String email ,@RequestParam String telephone ,
			@RequestParam String cin ,@RequestParam String role ,@RequestParam String login 
			,@RequestParam String password, @RequestParam Long departement_id ) {

		Employe employe;

		if (idEmploye == null) {
			employe = new Employe();
		} else {
			employe = employeDao.findOne(idEmploye);
		}

		employe.setAdresse(adresse);
		employe.setCin(cin);
		employe.setEmail(email);
		employe.setFirstName(firstName);
		employe.setLastName(lastName);
		employe.setLogin(login);
		employe.setPassword(password);
		employe.setRole(role);
		employe.setSexe(sexe);
		employe.setTelephone(telephone);
		employe.setDepartement(departementDao.findOne(departement_id));

		employeDao.save(employe);

		return new RedirectView("list");
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public RedirectView removeEmploye(@RequestParam Long idEmploye) {
		employeDao.delete(idEmploye);
		return new RedirectView("list");
	}

}