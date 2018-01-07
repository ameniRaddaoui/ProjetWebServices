package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Salle;
@Repository
public interface SalleRepository extends JpaRepository<Salle, Integer> {

}
