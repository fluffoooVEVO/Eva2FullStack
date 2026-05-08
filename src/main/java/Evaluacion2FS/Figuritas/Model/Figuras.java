package Evaluacion2FS.Figuritas.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Figuras")
public class Figuras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto_figura;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    private Integer id_figuras;

    @NotBlank(message = "El nombre no puede quedar vacío")
    @Size(min = 3, max = 60, message = "El nombre debe tener entre 3 y 60 caracteres")
    @Column(nullable = false, length = 60)
    private String nombre;

    @NotBlank(message = "La descripción no puede quedar vacía")
    @Size(min = 3, max = 255, message = "La descripción debe tener entre 3 y 255 caracteres")
    @Column(nullable = false, length = 255)
    private String descripcion;

}


