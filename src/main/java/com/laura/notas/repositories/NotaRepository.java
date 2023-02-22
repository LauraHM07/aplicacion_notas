package com.laura.notas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.notas.models.Nota;

public interface NotaRepository extends JpaRepository<Nota, Integer>{
    
}
