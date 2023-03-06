package com.jacaranda.springPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.springPrueba.model.Live;
import com.jacaranda.springPrueba.model.LiveId;

public interface LiveRepository extends JpaRepository<Live, LiveId> {

}