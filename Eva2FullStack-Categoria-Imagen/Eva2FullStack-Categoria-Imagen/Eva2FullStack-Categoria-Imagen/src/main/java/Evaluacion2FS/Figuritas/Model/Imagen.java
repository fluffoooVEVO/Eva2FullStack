package Evaluacion2FS.Figuritas.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY);
    private Integer id;

    @NotBlank(message = "El url no puede quedar vacio");
    @Size(max = 255,message = "El url tiene un maximo de hasta 255")


}
