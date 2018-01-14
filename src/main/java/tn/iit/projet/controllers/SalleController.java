package tn.iit.projet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.iit.projet.dao.SalleRepositorie;
import tn.iit.projet.entities.Salle;

@Controller
@RequestMapping("admin/salle")
public class SalleController {
	@Autowired
	private SalleRepositorie salleDao;
	
	
	@GetMapping
	@ResponseBody
	public List<Salle> liste() {
		return salleDao.findAll();

	}

	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		salleDao.delete(id);
		return "success";
	}
	
	
	@GetMapping("/{id}")
	@ResponseBody
	public Salle get(@PathVariable Long id) {
		return salleDao.findOne(id);
	}
	
	
	@PostMapping(value = "/")
	@ResponseBody
	public String createLanguage(@RequestBody Salle salle) {
		
		salleDao.save(salle);

		return "success";
	}

	
	@PutMapping("/")
	@ResponseBody
	public String editSalle(@RequestBody Salle salle) {
		
		
		salleDao.save(salle);
		return "success";
	}

}
