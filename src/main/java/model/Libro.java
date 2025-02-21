package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter


@Entity
@Table(name = "libro")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String titulo;
    @Column
    private int precio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_autor")
    private Autor autor;

   /* Relaciones */
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(
           name = "libreria_libro",
           joinColumns = @JoinColumn(name = "id_libro"),
           inverseJoinColumns = @JoinColumn(name = "id_libreria")
   )
   private List<Libreria> librerias;


    public Libro(String titulo, int precio, Editorial editorial, Autor autor) {
        this.titulo = titulo;
        this.precio = precio;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Libro(String titulo, int precio) {
        this.titulo = titulo;
        this.precio = precio;

    }

    public Libro(int id, List<Libreria> librerias) {
        this.id = id;
        this.librerias = librerias;
    }
}
