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

import tn.iit.projet.dao.SeanceRepositorie;
import tn.iit.projet.entities.Seance;

@Controller
@RequestMapping("admin/seance")
public class SeanceController {
	@Autowired
	private SeanceRepositorie seanceDao;

	
	@GetMapping
	@ResponseBody
	public List<Seance> liste() {
		return seanceDao.findAll();

	}

	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		seanceDao.delete(id);
		return "success";
	}

	
	@GetMapping("/{id}")
	@ResponseBody
	public Seance get(@PathVariable Long id) {
		return seanceDao.findOne(id);
	}
	
	
	@PostMapping(value = "/")
	@ResponseBody
	public String createseance(@RequestBody Seance seance) {
			seanceDao.save(seance);
			return "success";
		

	}
	
	
	@PutMapping("/")
	@ResponseBody
	public String editseance(@RequestBody Seance seance) {

		seanceDao.save(seance);
		return "success";
	}

}
