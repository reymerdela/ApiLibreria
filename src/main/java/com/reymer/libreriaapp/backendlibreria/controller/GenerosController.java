package com.reymer.libreriaapp.backendlibreria.controller;

import com.reymer.libreriaapp.backendlibreria.model.autor.DatosListadoAutores;
import com.reymer.libreriaapp.backendlibreria.model.genero.DatosListadoGeneros;
import com.reymer.libreriaapp.backendlibreria.model.genero.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/generos")
public class GenerosController {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public List<DatosListadoGeneros> obtenerAutores(){
        return generoRepository.findAll().stream().map(DatosListadoGeneros::new).toList();
    }
}
