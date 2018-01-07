package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Niveau;
@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Integer> {

}
