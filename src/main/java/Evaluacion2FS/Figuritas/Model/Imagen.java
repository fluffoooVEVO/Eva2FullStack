package Evaluacion2FS.Figuritas.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "imagen")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Integer idImagen;
    @NotBlank(message = "La URL no puede quedar vacía")
    @Size(max = 255, message = "La URL no puede sobrepasar los 255 caracteres")
    @Column(nullable = false, length = 255, name = "url")
    private String url;

    @NotNull(message = "El atributo orden no puede quedar nulo")
    @Column(nullable = false, name = "orden")
    private Integer orden;

    @NotBlank(message = "La descripción no puede quedar vacía")
    @Size(max = 255, message = "La descripción solo puede tener un máximo de 255 caracteres")
    @Column(nullable = false, length = 255, name = "descripcion")
    private String descripcion;
}