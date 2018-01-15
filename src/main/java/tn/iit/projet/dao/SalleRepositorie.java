package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Salle;
@Repository
public interface SalleRepositorie extends JpaRepository<Salle, Long> {
	
}
