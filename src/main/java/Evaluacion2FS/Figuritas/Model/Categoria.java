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
@Table(name="categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Integer idCategoria;

    @NotBlank(message="El nombre no puede quedar vacio")
    @Size(min=3,max=50,message="la categoria tiene que tener entre 3 y 50 caracteres")
    @Column(nullable=false,length=50)
    private String nombre;

    @NotBlank(message="La descripcion no puede quedar vacia")
    @Size(max=200,message="La descripcion no puede superar los 200 caracteres")
    @Column(nullable=false,length=200)
    private String descripcion;

    //Al momento de crear cualquier objeto siempre estara activo porque en teoria se "agrego" 
    //boolean es el nativo de java pero Boolean es del BeanValidation 
    @NotNull(message="El atributo status no puede quedar vacio")
    @Column(nullable=false)
    private Boolean status=true;

}
