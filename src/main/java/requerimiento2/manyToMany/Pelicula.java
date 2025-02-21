package requerimiento2.manyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int duracion;

    @ManyToMany(mappedBy = "peliculas")
    private List<Cliente> clientes;

    // Getters y setters
}
