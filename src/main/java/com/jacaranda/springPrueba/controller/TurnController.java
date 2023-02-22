package com.jacaranda.springPrueba.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.springPrueba.model.Jacarandenno;
import com.jacaranda.springPrueba.model.Turn;
import com.jacaranda.springPrueba.service.JacarandennoService;
import com.jacaranda.springPrueba.service.SignatureService;
import com.jacaranda.springPrueba.service.TurnService;

@Controller
public class TurnController {
	
	@Autowired
	TurnService turnService;
	
	@Autowired
	SignatureService signatureService;
	
	@Autowired
	JacarandennoService jacarandennoService;

	//Comprueba el rol del usuario logueado y en función de que sea estudiante
	// o profesor llamo a un servicio o a otro.
	// Si es profesor deberá llevar la palabra de búsqueda o null si no se busca nada
	
	@GetMapping({"index","/"})
	public String index(Model model, @RequestParam Optional<String> keyword) {	
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Jacarandenno jacarandenno = (Jacarandenno) auth.getPrincipal();
		if (jacarandenno.getRole().equals("STUDENT")){
			model.addAttribute("list",turnService.getTurns());
		}else {
			model.addAttribute("list",turnService.getTurnsToDo(keyword.orElse(null)));
		}
		
		return "index";
	}
	
	// Solcitar turno tengo que enviarle a la plantilla los módulos que existen para que
	// muestre el desplegable
	// Además le paso un objeto de la clase Turn para que almacene el módulo
	
	@GetMapping("/askTurn")
	public String askTurn(Model model) {
		model.addAttribute("listSignature",signatureService.getSignatures());
		model.addAttribute("turn", new Turn());
		return "askTurn";
	}
	
	// El objeto turn lo único que trae es el módulo, poer lo que tengo que terminar de
	// rellenarlo poníendo el turno a falso, el usuario al usuario loguteado yla hora la 
	// hora actual. Salvo y redirijo.
	@PostMapping("/askTurn/submit")
	public String askTurnSubmit(@ModelAttribute Turn turn) {
		turn.setDone(false);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Jacarandenno jacarandenno = (Jacarandenno) auth.getPrincipal();
		turn.setJacarandenno(jacarandenno);
		turn.setTime(LocalDateTime.now());
		turnService.save(turn);
		
		return "redirect:/index";
	}
	
	// Creo un un login para cambiar el login por defecto
	@GetMapping("login")
	public String login() {	
		
		return "login";
	}
	
	// Creo un logout
	@GetMapping("logout")
	public String logout() {	
		return "logout";
	}
	
//	@GetMapping({"toDo"})
//	public String todo(Model model) {	
//		model.addAttribute("list",turnService.getTurnsToDo());
//		return "index";
//	}
	
	// Cuando un profesor va a asistir un alumno hay que pasarle el id del alumno
	// las iniciales del módulo y la hora en qué solicitó unirse porque son primary key
	// Hay que conseguir el turno y pasárselo a la plantilla para que pueda mostrar
	// el nombre, usuarname, inicial y nombre del módulo
	
	@GetMapping({"assist"})
	public String assit(@RequestParam String username, @RequestParam  String initials,
			@RequestParam String time, Model model) {	
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(time, formatter);

		Turn turn = turnService.getTurn(username, initials, dateTime);
		model.addAttribute("turn",turn);
		
		return "assist";
	}
	
	// La plantilla lo que devuelve es el username del alumno, las iniciales del módulo
	// y la fecha, con eso yo tengo que conseguir el tuno de la base de dato. Lo 
	// modifico y lo salve. Por último redirijo
	
	@PostMapping({"assist/submit"})
	public String assit(@ModelAttribute Turn turn) {	
		
		Turn turnSave = turnService.getTurn(turn.getJacarandenno().getUsername(), 
										turn.getSignature().getInitials(), 
										turn.getTime());
		turnSave.setDone(true);
		turnService.save(turnSave);
		return "redirect:/index";
	}

}
