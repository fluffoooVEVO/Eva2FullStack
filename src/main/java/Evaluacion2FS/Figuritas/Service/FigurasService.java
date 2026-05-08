package Evaluacion2FS.Figuritas.Service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Evaluacion2FS.Figuritas.Model.Figuras;
import Evaluacion2FS.Figuritas.Repository.FigurasRepository;
import lombok.extern.slf4j.Slf4j;
@Service
public class FigurasService {

    @Autowired
    private FigurasRepository figurasRepository;

    public List<Figuras> obtenerTodos() {
        return figurasRepository.findAll();
    }

    public Figuras obtenerPorId(Integer id_producto_figura) {
        return figurasRepository.findById(id_producto_figura)
            .orElseThrow(() -> new RuntimeException("No se encontro registro con ID:" + id_producto_figura));
    }

    public String eliminarFigura(Integer id_producto_figura) {
        try {
            Figuras figura = figurasRepository.findById(id_producto_figura)
                .orElseThrow(() -> new RuntimeException("No se encontro registro con ID:" + id_producto_figura));
            figurasRepository.delete(figura);
            return "La figura a sido eliminada exitosamente";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Figuras guardarFigura(Figuras figuras) {
        return figurasRepository.save(figuras);
    }

    public Figuras actualizarFigura(Integer id_producto_figura, Figuras figuras) {
        
        Figuras figs = figurasRepository.findById(id_producto_figura)
            .orElseThrow(() -> new RuntimeException("No se encontro ID:" + id_producto_figura));
        if (figuras.getId_producto_figura() != null) {
            figs.setId_producto_figura(figuras.getId_producto_figura());
        }
        return figurasRepository.save(figs);
    }



}
