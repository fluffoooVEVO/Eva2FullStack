package Evaluacion2FS.Figuritas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Evaluacion2FS.Figuritas.Model.Edicion;
import Evaluacion2FS.Figuritas.Repository.EdicionRepository;

@Service
public class EdicionService {
    @Autowired
    EdicionRepository edicionRepository;

    public List<Edicion>obtenerTodos(){
        return edicionRepository.findAll();
    }

    public Edicion obtenerPorId(Integer id_Edicion){
        return edicionRepository.findById(id_Edicion)
        .orElseThrow(() -> new RuntimeException("No se encontro Edicion con la id"));
    }

    public String eliminarEdicion(Integer id_Edicion){
    try{
        Edicion edicion=edicionRepository.findById(id_Edicion)
        .orElseThrow(() -> new RuntimeException("No se encontro Edicion con la id"));
        edicionRepository.delete(edicion);
        return "Edicion eliminada correctamente";
        } catch (Exception e){
        return "Error al eliminar Edicion: " + e.getMessage();
        }
    }    

    public Edicion guardarEdicion(Edicion edicion){
        return edicionRepository.save(edicion);
    }

    public Edicion actualizarEdicion(Integer id_Edicion, Edicion edicion){
        Edicion edi=edicionRepository.findById(id_Edicion)
        .orElseThrow(()-> new RuntimeException("No se encontro Edicion con esa id"));
        if(edicion.getId_edicion() != null){
            edi.setId_edicion(edicion.getId_edicion());
        }
        return edicionRepository.save(edi);
    }
}
