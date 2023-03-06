package com.jacaranda.springPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.springPrueba.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
