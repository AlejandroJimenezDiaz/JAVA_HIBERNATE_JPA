package requerimiento2.oneToOne;

import jakarta.persistence.*;

@Entity
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private String ciudad;

    @OneToOne
    @JoinColumn(name = "cine_id")
    private Cine cine;

    // Getters y setters
}
