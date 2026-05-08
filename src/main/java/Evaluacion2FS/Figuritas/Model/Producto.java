package Evaluacion2FS.Figuritas.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

// entidad principal que almacena el catalogo fisico de productos
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Producto")
public class Producto {

    // identificador unico del producto
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_producto;

    // atributo principal con limite de caracteres definido en el esquema relacional
    @Column(nullable=false, length=150)
    private String nombre;

    // detalle extendido del producto
    @Column(length=1000)
    private String descripcion;

    // registro temporal de ingreso al sistema
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    // relacion obligatoria con la entidad marca (muchos productos pueden tener una marca)
    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    // relacion obligatoria con la entidad edicion
    @ManyToOne
    @JoinColumn(name = "id_edicion", nullable = false)
    private Edicion edicion;
}
