package com.reymer.libreriaapp.backendlibreria.model.genero;

import com.reymer.libreriaapp.backendlibreria.model.libro.Libro;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Genero")
@Table(name = "generos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;

    @ManyToMany(mappedBy = "generos")
    private Set<Libro> libros = new HashSet<>();

}
