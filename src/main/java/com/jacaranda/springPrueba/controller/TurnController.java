package com.jacaranda.springPrueba.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.jacaranda.springPrueba.service.JacarandennoService;
import com.jacaranda.springPrueba.service.SignatureService;
import com.jacaranda.springPrueba.service.TurnService;

@Controller
public class TurnController {
	
	@Autowired
	TurnService turnService;
	

	// Muestra sólo los turnos que no se han completado.
	@GetMapping({"index","/"})
	public String index(Model model) {	
		model.addAttribute("list",turnService.getTurns());
		return "index";
	}
	
	
	@GetMapping({"toDo"})
	public String todo(Model model) {	
		model.addAttribute("list",turnService.getTurnsToDo());
		return "index";
	}

}
