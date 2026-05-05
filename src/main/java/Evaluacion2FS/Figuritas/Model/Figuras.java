package Evaluacion2FS.Figuritas.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Figuras")
public class Figuras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_figuras;

    @NotBlank(message = "El nombre no puede quedar vacío")
    @Size(min = 3, max = 60, message = "El nombre debe tener entre 3 y 60 caracteres")
    @Column(nullable = false, length = 60)
    private String nombre;

    @NotBlank(message = "La descripción no puede quedar vacía")
    @Size(min = 3, max = 255, message = "La descripción debe tener entre 3 y 255 caracteres")
    @Column(nullable = false, length = 255)
    private String descripcion;

    // Relación con Edicion (sin @JoinColumn, JPA infiere el nombre de columna)
    @ManyToOne(fetch = FetchType.LAZY)
    private Edicion edicion;

    // Lista de figuras (sin cascade, operaciones no se propagan automáticamente)
    @OneToMany(mappedBy = "figuras", fetch = FetchType.LAZY)
    private List<Figura> figuras;
}
