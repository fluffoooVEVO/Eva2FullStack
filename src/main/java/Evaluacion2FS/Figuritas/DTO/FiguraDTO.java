package Evaluacion2FS.Figuritas.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FiguraDTO {
    private Integer id_figura;

    @NotBlank(message = "El nombre de la figura es obligatorio")
    @Size(max = 200, message =  "El nombre tiene un limite de 200 caracteres")
    private String nombre;
}

