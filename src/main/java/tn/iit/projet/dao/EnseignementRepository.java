package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Enseignement;


@Repository
public interface EnseignementRepository extends JpaRepository<Enseignement, Integer> {

}
