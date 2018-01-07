package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Pointage;
@Repository
public interface PointageRepository extends JpaRepository<Pointage, Integer> {

}
