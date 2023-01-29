package com.jacaranda.springPrueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jacaranda.springPrueba.model.Jacarandenno;
import com.jacaranda.springPrueba.repository.JacarandennoRepository;

@Service
public class JacarandennoService implements UserDetailsService {

	@Autowired
	JacarandennoRepository repository;
	
	
	public Jacarandenno getJacarandenno(String id){
		return repository.findById(id).orElse(null);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Jacarandenno student = repository.findById(username).orElse(null);
		if (student == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return student;
	}

}
