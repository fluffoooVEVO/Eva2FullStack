package Evaluacion2FS.Figuritas.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//id_figura, nombre, descripcion y url
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Figura")
public class Figura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_figura;

    @NotBlank(message="El nombre no puede quedar con atributo vacio")
    @Size(min=3, max=60, message="El nombre debe tener entre 3 y 60 caracteres")
    @Column(nullable=false, length=60)
    private String nombre;

    @NotBlank(message="La descripcion no puede quedar con atributo vacio")
    @Size(min=3, max=255, message="La descripcion debe tener entre 3 y 255 caracteres")
    @Column(nullable=false, length=255)
    private String descripcion;

    @Column(nullable=true, length=255)
    private String url;

    // Relación con Figuras (colección a la que pertenece, sin @JoinColumn)
    @ManyToOne(fetch = FetchType.LAZY)
    private Figuras figuras;
}