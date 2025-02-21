package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor

@NamedQuery(name="Autor.obtenerAutores", query = "SELECT a FROM Autor a")

@Entity // Definemos que es una entidad
@Table(name = "autor") //indicamos el nombre de la tabla
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private LocalDate fecha_nacimiento;


    /*Espacio para declarar después el tipo de relación que tiene contra otra entidad OneToMany-OneToOne-ManyToMany*/
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Libro> libros;



    public Autor(String nombre, String apellido, LocalDate fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
