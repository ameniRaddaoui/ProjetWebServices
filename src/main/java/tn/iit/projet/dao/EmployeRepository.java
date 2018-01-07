package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository <Employe, Long> {
	Employe getEmployeByLogin(String login);
	

}
