package com.jacaranda.springPrueba.service;

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
	
	public List<Turn> getTurnsToDo(){
		return repository.findToDo();
	}
	
	public Turn save(Turn turn) {
		return repository.save(turn);
	}

	
}
