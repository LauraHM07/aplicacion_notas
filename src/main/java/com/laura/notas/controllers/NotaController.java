package com.laura.notas.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laura.notas.models.Nota;
import com.laura.notas.services.NotaService;

@RestController
public class NotaController {
    
    @Autowired
    NotaService notaService;

    @GetMapping("/lista")
    List<Nota> all(){
        return notaService.findAll();
    }

    @PostMapping("/nueva")
    Nota crearNota(@RequestBody Nota nota){
        notaService.save(nota);
        return nota;
    }

    @DeleteMapping("/borrar/{id}")
    void deleteNota(@PathVariable int id){
        notaService.deleteById(id);
    }

    
    @PutMapping("/editar/{id}")
    void modificarNota(@PathVariable int id, @RequestBody Nota nota){
        notaService.update(id, nota);
    }

    @GetMapping("/buscar/{id}")
    Nota findNota(@PathVariable int id){
        return notaService.findById(id);
    }

    @GetMapping("/buscar/titulo")
    public List<Nota> findNotaTitulo(@RequestParam("titulo") String titulo){
        List<Nota> notas = notaService.findAll();
        List<Nota> notasEncontradas = new ArrayList<Nota>();

        for (Nota nota : notas){
            if (nota.getTitulo().contains(titulo)){
                notasEncontradas.add(nota);
            }
        }

        return notasEncontradas;
    }

    @GetMapping("/buscar/ambas")
    public List<Nota> findNotaAmbas(@RequestParam("titulo") String titulo, @RequestParam("fecha") @DateTimeFormat(pattern="dd/MM/yyyy") Date fecha){
        List<Nota> notas = notaService.findAll();
        List<Nota> notasEncontradas = new ArrayList<Nota>();

        for (Nota nota : notas){
            if (nota.getTitulo().contains(titulo) && nota.getFecha().after(fecha)){
                notasEncontradas.add(nota);
            }
        }

        return notasEncontradas;
    }
}
