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

import tn.iit.projet.dao.EnsignantRepositorie;
import tn.iit.projet.entities.Enseignant;

@Controller
@RequestMapping("admin/enseignant")
public class EnseignantController {
	@Autowired
	private EnsignantRepositorie ensignantRepositorie;

	
	@GetMapping
	@ResponseBody
	public List<Enseignant> liste() {
		return ensignantRepositorie.findAll();

	}

	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		ensignantRepositorie.delete(id);
		return "success";
	}


	@GetMapping("/{id}")
	@ResponseBody
	public Enseignant get(@PathVariable Long id) {
		return ensignantRepositorie.findOne(id);
	}

	
	@PostMapping(value = "/")
	@ResponseBody
	public String createEnsignat(@RequestBody Enseignant user) {
		ensignantRepositorie.save(user);
		return "success";
	}

	
	@PutMapping("/")
	@ResponseBody
	public String editEnseignant(@RequestBody Enseignant user) {
		Enseignant e = user;
		ensignantRepositorie.save(e);
		return "success";
	}

}
