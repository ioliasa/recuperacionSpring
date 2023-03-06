package com.jacaranda.springPrueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.springPrueba.model.City;
import com.jacaranda.springPrueba.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	CityRepository citRepository;
	
	public List<City> findAll(){
		return citRepository.findAll();
	}
	
}
