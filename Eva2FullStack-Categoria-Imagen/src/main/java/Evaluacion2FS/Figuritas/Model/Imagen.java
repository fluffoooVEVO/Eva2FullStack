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
@Table(name = "Imagen")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message="El atributo no puede quedar vacio ")
    @Size(max = 255,message = "La url no puede sobrepasar los 255 caracteres")
    @Column(nullable=false,length=255,name="url") 
    private String url;

    @NotNull(message = "El atributo orden no puede quedar nulo")
    @Column(nullable = false,name = "orden")
    private Integer orden;

    @NotBlank(message = "El atributo descripcion no puede quedar vacion")
    @Size(max = 255,message = "La descripcion solo tiene un maximo de 255 palabras")
    @Column(nullable = false,name = "descripcion")
    private String descripcion;
}




