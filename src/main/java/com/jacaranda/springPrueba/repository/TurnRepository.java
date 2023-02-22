package com.jacaranda.springPrueba.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jacaranda.springPrueba.model.Turn;
import com.jacaranda.springPrueba.model.TurnId;

public interface TurnRepository extends JpaRepository<Turn,TurnId>{

	public List<Turn> findAllByOrderByTimeDesc();
	@Query("SELECT u FROM Turn u WHERE u.done=0 order by time")
	public List<Turn> findToDo();
	
	@Query(value="select * from turn where id_student = ?1 and initials_module =?2 and time=?3",nativeQuery=true)
	public Turn findTurn(String jacarandenno, String signature, LocalDateTime time);
	
	@Query(value="select * from turn join module on turn.initials_module = module.initials where module.name like ?1 and done=0",nativeQuery=true)
	public List<Turn> findByLikeSignatureName(String keyword);
}
