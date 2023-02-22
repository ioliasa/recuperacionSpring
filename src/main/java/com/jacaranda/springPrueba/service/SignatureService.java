package com.jacaranda.springPrueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.springPrueba.model.Signature;
import com.jacaranda.springPrueba.repository.SignatureRepository;

@Service
public class SignatureService {
	
	@Autowired
	SignatureRepository repository;
	
	public Signature getSignature(String id){
		return repository.findById(id).orElse(null);
	}

	public List<Signature> getSignatures(){
		return repository.findAll();
	}
}
