package com.jacaranda.springPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.springPrueba.model.Signature;

public interface SignatureRepository extends JpaRepository<Signature, String> {

}
