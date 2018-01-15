package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Seance;

@Repository
public interface SeanceRepositorie extends JpaRepository<Seance, Long> {


}
