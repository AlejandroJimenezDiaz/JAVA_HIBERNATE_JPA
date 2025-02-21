package requerimiento2.oneToMany;

import jakarta.persistence.*;
import requerimiento2.oneToOne.Cine;

@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int capacidad;

    @ManyToOne
    @JoinColumn(name = "cine_id")
    private Cine cine;

    // Getters y setters
}
