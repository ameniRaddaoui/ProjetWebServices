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

import tn.iit.projet.dao.GroupeRepositorie;
import tn.iit.projet.entities.Groupe;

@Controller
@RequestMapping("admin/groupe")
public class GroupeController {
	@Autowired
	private GroupeRepositorie groupeRepositorie;

	
	@GetMapping
	@ResponseBody
	public List<Groupe> liste() {
		return groupeRepositorie.findAll();

	}
	
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		groupeRepositorie.delete(id);
		return "success";
	}

	
	@GetMapping("/{id}")
	@ResponseBody
	public Groupe get(@PathVariable Long id) {
		return groupeRepositorie.findOne(id);
	}

	
	@PostMapping(value = "/")
	@ResponseBody
	public String createLanguage(@RequestBody Groupe groupe) {
		groupeRepositorie.save(groupe);
		return "success";
	}

	
	@PutMapping("/")
	@ResponseBody
	public String editLanguage(@RequestBody Groupe groupe) {
		groupeRepositorie.save(groupe);
		return "success";
	}

}
