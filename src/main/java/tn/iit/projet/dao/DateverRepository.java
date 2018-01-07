package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Datever;
@Repository
public interface DateverRepository extends JpaRepository<Datever, String>{

}
