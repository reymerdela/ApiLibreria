package com.reymer.libreriaapp.backendlibreria.model.genero;

public record DatosListadoGeneros(Long id, String nombre) {
    public DatosListadoGeneros(Genero genero){
        this(genero.getId(),genero.getNombre());
    }
}
