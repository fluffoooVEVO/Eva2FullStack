package Evaluacion2FS.Figuritas.Model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Enlaces {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_enlace;

    // el nombre del enlace es obligatorio y maximo 100 caracteres
    @Column(nullable = false, length = 100)
    private String nombre;

    // la url tambien es obligatoria para que no guarden enlaces vacios
    @Column(nullable = false, length = 255)
    private String url;
}
