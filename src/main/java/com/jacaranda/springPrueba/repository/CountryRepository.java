package com.jacaranda.springPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.springPrueba.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
