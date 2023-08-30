package com.reymer.libreriaapp.backendlibreria.model.libro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

public record DatosRegistrarLibro(

        @NotBlank
        String titulo,
        @NotNull
        Long autorId,
        @NotNull
        Set<Long> generoId,
        String imagen,
        String descripcion,
        @NotNull
        BigDecimal precio,
        Integer stock) {
}
