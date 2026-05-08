package Evaluacion2FS.Figuritas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Evaluacion2FS.Figuritas.Model.Figuras;
import Evaluacion2FS.Figuritas.Repository.FigurasRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FigurasService {

    @Autowired
    private FigurasRepository figurasRepository;

    public List<Figuras> obtenerTodos() {
        log.info("Obteniendo todas las figuras");
        List<Figuras> figuras = figurasRepository.findAll();
        log.debug("Cantidad de figuras encontradas: ", figuras.size());
        return figuras;
    }

    public Figuras obtenerPorId(Integer id_producto_figura) {
        log.info("Buscando figura con ID: ", id_producto_figura);
        Figuras figuras = figurasRepository.findById(id_producto_figura)
            .orElseThrow(() -> {
                log.error("Figura no encontrada con ID: ", id_producto_figura);
                return new RuntimeException("No se encontro registro con ID:" + id_producto_figura);
            });
        log.debug("Figura encontrada: ", figuras.getNombre());
        return figuras;
    }

    public String eliminarFigura(Integer id_producto_figura) {
        log.info("Iniciando eliminación de figura con ID: ", id_producto_figura);
        try {
            Figuras figuras = figurasRepository.findById(id_producto_figura)
                .orElseThrow(() -> {
                    log.error("Figura no encontrada al eliminar con ID: ", id_producto_figura);
                    return new RuntimeException("No se encontro registro con ID:" + id_producto_figura);
                });
            figurasRepository.delete(figuras);
            log.info("Figura eliminada correctamente con ID: ", id_producto_figura);
            return "La figura a sido eliminada exitosamente";
        } catch (Exception e) {
            log.error("Error al eliminar figura: ", e.getMessage(), e);
            return e.getMessage();
        }
    }

    public Figuras guardarFigura(Figuras figuras) {
        log.info("Guardando figura: ", figuras.getNombre());
        Figuras saved = figurasRepository.save(figuras);
        log.info("Figura guardada correctamente con ID: ", saved.getId_producto_figura());
        return saved;
    }

    public Figuras actualizarFigura(Integer id_producto_figura, Figuras figuras) {
        log.info("Actualizando figura con ID: ", id_producto_figura);
        Figuras figs = figurasRepository.findById(id_producto_figura)
            .orElseThrow(() -> {
                log.error("Figura no encontrada al actualizar con ID: ", id_producto_figura);
                return new RuntimeException("No se encontro ID: " + id_producto_figura);
            });
        if (figuras.getNombre() != null) {
            log.debug("Actualizando nombre de figura a: ", figuras.getNombre());
            figs.setNombre(figuras.getNombre());
        }
        if (figuras.getDescripcion() != null) {
            log.debug("Actualizando descripción de figura");
            figs.setDescripcion(figuras.getDescripcion());
        }
        Figuras updated = figurasRepository.save(figs);
        log.info("Figura actualizada correctamente con ID: ", id_producto_figura);
        return updated;
    }

}
