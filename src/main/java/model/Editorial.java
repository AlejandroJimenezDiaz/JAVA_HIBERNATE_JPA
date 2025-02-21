package model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter@Setter@AllArgsConstructor@NoArgsConstructor



@Entity
@Table(name = "editorial")
public class Editorial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String direccion;

    /* Espacio para definir el tipo de relación con otra entidad*/
    @OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Editorial(int id) {
        this.id = id;
    }
}
