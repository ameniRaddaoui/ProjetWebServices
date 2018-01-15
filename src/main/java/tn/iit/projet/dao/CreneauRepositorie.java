package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Creneau;

@Repository
public interface CreneauRepositorie extends JpaRepository<Creneau, Long> {
	


}
