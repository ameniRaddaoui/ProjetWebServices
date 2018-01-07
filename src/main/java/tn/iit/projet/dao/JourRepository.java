package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Jour;

	
@Repository
public interface JourRepository extends JpaRepository<Jour, Integer> {

}
