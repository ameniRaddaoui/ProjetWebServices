package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Matiere;


@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Integer> {

}
