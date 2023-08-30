package com.reymer.libreriaapp.backendlibreria.controller;

import com.reymer.libreriaapp.backendlibreria.model.autor.Autor;
import com.reymer.libreriaapp.backendlibreria.model.autor.AutorRepository;
import com.reymer.libreriaapp.backendlibreria.model.genero.Genero;
import com.reymer.libreriaapp.backendlibreria.model.genero.GeneroRepository;
import com.reymer.libreriaapp.backendlibreria.model.libro.DatosListadoLibros;
import com.reymer.libreriaapp.backendlibreria.model.libro.DatosRegistrarLibro;
import com.reymer.libreriaapp.backendlibreria.model.libro.Libro;
import com.reymer.libreriaapp.backendlibreria.model.libro.LibroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("api/v1/libros")
@CrossOrigin(origins = "http://localhost:3000")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private GeneroRepository generoRepository;

    @PostMapping
    public void registrarLibro(@RequestBody @Valid DatosRegistrarLibro datosRegistrarLibro){
        System.out.println(datosRegistrarLibro);
        Autor autor = autorRepository.findById(datosRegistrarLibro.autorId()).get();
        Set<Genero> generos = new HashSet<>(generoRepository.findAllById(datosRegistrarLibro.generoId()));
        libroRepository.save(new Libro(datosRegistrarLibro,autor,generos));
    }

    @GetMapping
    public List<DatosListadoLibros> listadoLibros(){
        return libroRepository.findAll().stream().map(DatosListadoLibros::new).toList();
    }
}
