package tn.iit.projet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.projet.entities.User;



@Repository
public interface UserDAO extends JpaRepository<User, Long>
{
	List<User> findByUsername(String username);
	
	User getUserByLogin(String password);
}

