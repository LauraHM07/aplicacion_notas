package com.laura.notas.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laura.notas.models.Nota;
import com.laura.notas.repositories.NotaRepository;
import com.laura.notas.services.NotaService;

@Service
public class NotaServiceImpl implements NotaService {
    
    @Autowired
    NotaRepository repository;

    @Override
    public List<Nota> findAll() {
        return repository.findAll();
    }

    @Override
    public Nota findById(int id) {
        Optional<Nota> findById = repository.findById(id);

        if(findById != null) {
            return findById.get();
        }

        return null;
    }

    @Override
    public Nota save(Nota nota) {
        return repository.save(nota);
    }

    @Override
    public void update(int id, Nota nota) {
        this.findById(id);

        nota.setId(id);

        repository.save(nota);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
       repository.deleteAll();
    }
}
