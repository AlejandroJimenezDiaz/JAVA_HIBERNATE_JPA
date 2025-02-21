package requerimiento2.oneToOne;

import jakarta.persistence.*;
import requerimiento2.oneToMany.Sala;

import java.util.List;

@Entity
public class Cine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne(mappedBy = "cine")
    private Ubicacion ubicacion;

    @OneToMany(mappedBy = "cine", cascade = CascadeType.ALL)
    private List<Sala> salas;

    // Getters y setters
}
