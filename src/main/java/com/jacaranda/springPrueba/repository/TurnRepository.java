package com.jacaranda.springPrueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jacaranda.springPrueba.model.Turn;
import com.jacaranda.springPrueba.model.TurnId;

public interface TurnRepository extends JpaRepository<Turn,TurnId>{

	public List<Turn> findAllByOrderByTimeDesc();
	@Query("SELECT u FROM Turn u WHERE u.done=0 order by time")
	public List<Turn> findToDo();
}
