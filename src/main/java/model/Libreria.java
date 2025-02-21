package model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor


@Entity
@Table(name = "libreria")
public class Libreria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String dueño;
    @Column
    private String direccion;

    @ManyToMany(mappedBy = "librerias",fetch = FetchType.EAGER) // Relación bidireccional con 'Libro'
    private List<Libro> libros;

    public Libreria(String nombre, String dueño, String direccion) {
        this.nombre = nombre;
        this.dueño = dueño;
        this.direccion = direccion;
    }
}
