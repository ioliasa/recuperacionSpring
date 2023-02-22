package com.jacaranda.springPrueba.service;


import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.springPrueba.model.Turn;
import com.jacaranda.springPrueba.repository.TurnRepository;

@Service
public class TurnService {
	
	@Autowired
	TurnRepository repository;
	
	
	
	
	public List<Turn> getTurns(){
		return repository.findAllByOrderByTimeDesc();
	}
	
	public Turn getTurn(String jacarandenno, String signature, LocalDateTime time) {
		
		return repository.findTurn(jacarandenno, signature, time);
	}
	
	public List<Turn> getTurnsToDo(String keyword){
		if (keyword == null)
			return repository.findToDo();
		else
			return repository.findByLikeSignatureName("%" + keyword +"%");
	}
	
	public Turn save(Turn turn) {
		return repository.save(turn);
	}

	
}
