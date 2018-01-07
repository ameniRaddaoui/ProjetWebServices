package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Enseignant;


@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {

}
