package com.jacaranda.springPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.springPrueba.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
