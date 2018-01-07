package tn.iit.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.Registre;
@Repository
public interface RegistreRepository extends JpaRepository<Registre, String> {

}
