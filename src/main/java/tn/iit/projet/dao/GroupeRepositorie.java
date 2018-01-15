package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Groupe;
@Repository
public interface GroupeRepositorie extends JpaRepository<Groupe, Long> {
	
}
