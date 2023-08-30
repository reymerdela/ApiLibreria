package com.reymer.libreriaapp.backendlibreria.model.libro;

import com.reymer.libreriaapp.backendlibreria.model.autor.Autor;
import com.reymer.libreriaapp.backendlibreria.model.autor.AutorRepository;
import com.reymer.libreriaapp.backendlibreria.model.genero.Genero;
import com.reymer.libreriaapp.backendlibreria.model.genero.GeneroRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "Libro")
@Table(name = "libros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    private String imagen;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_genero",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private Set<Genero> generos;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;

    public Libro(DatosRegistrarLibro datosRegistrarLibro,Autor autor, Set<Genero> genero) {
        this.titulo = datosRegistrarLibro.titulo();
        this.autor = autor;
        this.generos = genero;
        this.descripcion = datosRegistrarLibro.descripcion();
        this.precio = datosRegistrarLibro.precio();
        this.stock = datosRegistrarLibro.stock();
        this.imagen = datosRegistrarLibro.imagen();
    }
}
