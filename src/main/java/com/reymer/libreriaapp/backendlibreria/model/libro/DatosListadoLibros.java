package com.reymer.libreriaapp.backendlibreria.model.libro;

import com.reymer.libreriaapp.backendlibreria.model.genero.Genero;


import java.math.BigDecimal;

import java.util.List;


public record DatosListadoLibros(Long id, String titulo, String autor, List<String> generos, String descripcion,
  BigDecimal precio, Integer stock,String imagen) {


    public DatosListadoLibros(Libro libro){
        this(libro.getId(),libro.getTitulo(),
        libro.getAutor().getNombre(),
        libro.getGeneros().stream().map(Genero::getNombre).toList(),
        libro.getDescripcion(),
        libro.getPrecio(),
        libro.getStock(),libro.getImagen());
    }


}
