package Evaluacion2FS.Figuritas.Model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Enlaces {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_enlace;
}
