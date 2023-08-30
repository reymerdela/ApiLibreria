package com.reymer.libreriaapp.backendlibreria.controller;

import com.reymer.libreriaapp.backendlibreria.model.autor.Autor;
import com.reymer.libreriaapp.backendlibreria.model.autor.AutorRepository;
import com.reymer.libreriaapp.backendlibreria.model.autor.DatosListadoAutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/autores")
@CrossOrigin(origins = "http://localhost:3000")
public class AutoresController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<DatosListadoAutores> obtenerAutores(){
        return autorRepository.findAll().stream().map(DatosListadoAutores::new).toList();
    }
}
