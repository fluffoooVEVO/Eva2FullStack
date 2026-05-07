package Evaluacion2FS.Figuritas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Evaluacion2FS.Figuritas.DTO.FiguraDTO;
import Evaluacion2FS.Figuritas.Model.Figura;
import Evaluacion2FS.Figuritas.Repository.FiguraRepository;

@Service
public class FiguraService {
        @Autowired
        FiguraRepository figuraRepository;

        public List<Figura>obtenerTodos(){
            return figuraRepository.findAll();
            //if(lista)vacia que salte excpetion
        }

        public Figura obtenerPorId(Integer id_Figura){
            return figuraRepository.findById(id_Figura)
            .orElseThrow(() -> new RuntimeException("No se encontro Figura con la id"));
        }

        public String eliminarFigura(Integer id){
        try {
            Figura figura=figuraRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("No se encontro registro con ID:"+id));
            figuraRepository.delete(figura);
            return "La figura a sido eliminada exitosamente";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

        public Figura guardarFigura(Figura figura){
            return figuraRepository.save(figura);
        }

        public Figura actualizarFigura(Integer id, Figura figura){
            Figura fig=figuraRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("No se encontro registro con ID:"+id));
            if(figura.getNombre() != null){
                fig.setNombre(figura.getNombre());
            }
            if(figura.getDescripcion() != null){
                fig.setDescripcion(figura.getDescripcion());
            }
            if(figura.getUrl() != null){
                fig.setUrl(figura.getUrl());
            }
            return figuraRepository.save(fig);
        }

        public FiguraDTO convertirADTO(Figura figura){
            FiguraDTO figuraDTO = new FiguraDTO();
            figuraDTO.setId_figura(figura.getId_figura());
            figuraDTO.setNombre(figura.getNombre());
            return figuraDTO;
        }

        public List<FiguraDTO> convertirListaADTO(List<Figura> figuras){
            return figuras.stream()
            .map(this::convertirADTO)
            .toList();
        }

        public FiguraDTO obtenerDTOporId(Integer id_Figura){
            Figura figura = figuraRepository.findById(id_Figura)
            .orElseThrow(() -> new RuntimeException("No se encontro Figura con la id"));
            return convertirADTO(figura);
        }
}
