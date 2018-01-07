package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Departement;


@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer>{

}
