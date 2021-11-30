package com.example.SportyShoes.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SportyShoes.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	List<Person> findByIsRegistered(boolean b);

	Person findByUsernameAndPassword(String username, String password);

	Person findByUsername(String username);

	@Modifying
	@Transactional
	@Query("update Person log set log.password=:password where log.id=:id")
	void changePassword(@Param(value = "password") String password, @Param(value = "id") Integer id);

}
