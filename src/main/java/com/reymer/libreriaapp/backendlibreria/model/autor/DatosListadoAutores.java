package com.reymer.libreriaapp.backendlibreria.model.autor;

public record DatosListadoAutores(Long id, String nombre, String biografia,String imagen) {

    public DatosListadoAutores(Autor autor){
        this(autor.getId(), autor.getNombre(),autor.getBiografia(), autor.getImagen());
    }
}
