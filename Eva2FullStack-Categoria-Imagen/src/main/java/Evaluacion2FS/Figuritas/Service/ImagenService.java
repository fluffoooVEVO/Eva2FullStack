package Evaluacion2FS.Figuritas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Evaluacion2FS.Figuritas.DTO.CategoriaDTO;
import Evaluacion2FS.Figuritas.DTO.ImagenDTO;
import Evaluacion2FS.Figuritas.Model.Categoria;
import Evaluacion2FS.Figuritas.Model.Imagen;
import Evaluacion2FS.Figuritas.Repository.ImagenRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImagenService {
    @Autowired
    private ImagenRepository imagenRepository;

    public Categoria convertirAEntidad(CategoriaDTO dto) {
    Categoria categoria = new Categoria();
    
    categoria.setIdCategoria(dto.getIdCategoria());
    categoria.setNombre(dto.getNombre());
    categoria.setDescripcion(dto.getDescripcion());
    categoria.setStatus(dto.getStatus());
    return categoria;
    }

    public ImagenDTO convertirADTO(Imagen imagen){
        ImagenDTO dto=new ImagenDTO();
        dto.setUrl(imagen.getUrl());
        dto.setOrden(imagen.getOrden());
        dto.setDescripcion(imagen.getDescripcion());
        return dto;
    }

    public List<ImagenDTO>obtenerTodasDTO(){
        return imagenRepository.findAll().stream()
        .map(this::convertirADTO)
        .toList();
    }

    public ImagenDTO obtenerPorIdDTO(Integer id){
        log.info("Buscando ID:{}",id);
        Imagen imagen=imagenRepository.findById(id)
        .orElseThrow(()->{
            log.error("Error:no se encontro la imagen con id{}",id);
            return new RuntimeException("no se encontro el registro con ID:"+id);
        });
        log.info("Imagen encontrada exitosamente");
        return convertirADTO(imagen);
    }

    public ImagenDTO guardarDTO(ImagentDTO dto){
        log.info(msg);
    }

}
