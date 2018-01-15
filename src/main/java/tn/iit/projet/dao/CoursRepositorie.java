package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Cours;

@Repository
public interface CoursRepositorie extends JpaRepository<Cours, Long> {
	


}
