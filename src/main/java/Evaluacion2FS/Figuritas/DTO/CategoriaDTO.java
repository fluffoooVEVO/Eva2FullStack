package Evaluacion2FS.Figuritas.DTO;

import lombok.Data;

@Data 
public class CategoriaDTO {
    private Integer idCategoria;
    private String nombre;
    private String descripcion;
    private Boolean status = true;
}