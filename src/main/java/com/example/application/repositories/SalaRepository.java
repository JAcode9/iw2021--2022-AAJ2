package com.example.application.repositories;

import com.example.application.domain.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SalaRepository extends JpaRepository<Sala, Integer> {

    List<Sala> findByFuncional(boolean b);

}