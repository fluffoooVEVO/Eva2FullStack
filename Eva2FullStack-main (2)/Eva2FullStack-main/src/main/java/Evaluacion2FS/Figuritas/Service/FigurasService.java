package Evaluacion2FS.Figuritas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Evaluacion2FS.Figuritas.DTO.FigurasDTO;
import Evaluacion2FS.Figuritas.Model.Figuras;
import Evaluacion2FS.Figuritas.Repository.FigurasRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FigurasService {

    @Autowired
    private FigurasRepository figurasRepository;

    private FigurasDTO convertirADTO(Figuras figura){
        FigurasDTO dto= new FigurasDTO();
        dto.setId_producto_figura(figura.getId_producto_figura());
        dto.setId_producto(figura.getProducto().getId_producto());
        dto.setId_figura(figura.getFigura().getId_figura());
        return dto;
    }

    private Figuras convertirAEntidad(FigurasDTO dto){
        Figuras figura = new Figuras();
        figura.setId_producto_figura(dto.getId_producto_figura());
        figura.setProducto(null);
        figura.setFigura(null);
        return figura;
    }



    public List<Figuras> obtenerTodos() {
        log.info("Obteniendo todas las figuras");
        List<Figuras> figuras = figurasRepository.findAll();
        log.debug("Cantidad de figuras encontradas: ", figuras.size());
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
        log.info("Guardando nueva figura");
        Figuras figuraGuardada = figurasRepository.save(figuras);
        log.info("Figura guardada con ID: ", figuraGuardada.getId_producto_figura());
        return figuraGuardada;
    }

    public Figuras actualizarFigura(Integer id_producto_figura, Figuras figuras) {
        log.info("Iniciando actualización de figura con ID: ", id_producto_figura);
        try {
            Figuras figuraExistente = figurasRepository.findById(id_producto_figura)
                .orElseThrow(() -> {
                    log.error("Figura no encontrada al actualizar con ID: ", id_producto_figura);
                    return new RuntimeException("No se encontro registro con ID:" + id_producto_figura);
                });
            figuraExistente.setProducto(figuras.getProducto());
            figuraExistente.setFigura(figuras.getFigura());
            Figuras figuraActualizada = figurasRepository.save(figuraExistente);
            log.info("Figura actualizada correctamente con ID: ", figuraActualizada.getId_producto_figura());
            return figuraActualizada;
        } catch (Exception e) {
            log.error("Error al actualizar figura: ", e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
    
}
