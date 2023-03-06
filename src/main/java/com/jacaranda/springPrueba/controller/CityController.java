package com.jacaranda.springPrueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jacaranda.springPrueba.model.City;
import com.jacaranda.springPrueba.service.CityService;

@Controller
public class CityController {
	
	@Autowired
	CityService cityService;
	
	@GetMapping("/prueba")
	public void prueba() {
		List<City> lista = cityService.findAll();
	}
}
