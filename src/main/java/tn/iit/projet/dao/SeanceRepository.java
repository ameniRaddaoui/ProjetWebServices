package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Seance;
@Repository
public interface SeanceRepository extends JpaRepository<Seance, Integer> {

}
