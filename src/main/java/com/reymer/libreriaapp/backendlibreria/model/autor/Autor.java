package com.reymer.libreriaapp.backendlibreria.model.autor;


import com.reymer.libreriaapp.backendlibreria.model.libro.Libro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Autor")
@Table(name = "autores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imagen;
    @Column(columnDefinition = "TEXT")
    private String biografia;

    @OneToMany(mappedBy = "autor")
    private Set<Libro> libros = new HashSet<>();

}
