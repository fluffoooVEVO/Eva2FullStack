package Evaluacion2FS.Figuritas.Service;

import Evaluacion2FS.Figuritas.DTO.EnlaceDTO2;
import Evaluacion2FS.Figuritas.Exception.ResourceNotFoundException;
import Evaluacion2FS.Figuritas.Model.Enlace;
import Evaluacion2FS.Figuritas.Repository.EnlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// le avisamos a spring que esta clase maneja la logica pesada de los enlaces
@Service
public class EnlaceService {

    // traemos el repositorio para poder hacer consultas a la base de datos
    @Autowired
    private EnlaceRepository enlaceRepository;

    // metodo para transformar lo que sale de la base de datos a un formato dto
    private EnlaceDTO2 convertirADto(Enlace enlace) {
        EnlaceDTO2 dto = new EnlaceDTO2();
        dto.setId_enlace(enlace.getId_enlace());
        dto.setNombre(enlace.getNombre());
        dto.setUrl(enlace.getUrl());
        return dto;
    }

    // lo mismo pero al reves. agarra el dto que manda el usuario y lo pasa a modelo para guardarlo
    private Enlace convertirAModelo(EnlaceDTO2 dto) {
        Enlace enlace = new Enlace();
        enlace.setNombre(dto.getNombre());
        enlace.setUrl(dto.getUrl());
        return enlace;
    }

    // listar todos los enlaces
    public List<EnlaceDTO2> obtenerTodos() {
        // sacamos la lista cruda desde la base de datos
        List<Enlace> listaEnlaces = enlaceRepository.findAll();
        // preparamos una lista vacia para los dtos
        List<EnlaceDTO2> listaDtos = new ArrayList<>();

        // recorremos uno por uno con un for y los vamos agregando a la lista nueva
        for (Enlace enlace : listaEnlaces) {
            EnlaceDTO2 dto = convertirADto(enlace);
            listaDtos.add(dto);
        }
        return listaDtos;
    }

    // buscar un puro enlace por su numero de id
    public EnlaceDTO2 buscarPorId(Integer id) {
        // si no lo encuentra salta el atajador de errores
        Enlace enlace = enlaceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no se encontro ningun enlace con el id " + id));
        return convertirADto(enlace);
    }

    // crear un enlace de cero
    public EnlaceDTO2 guardarEnlace(EnlaceDTO2 enlaceDTO) {
        Enlace nuevoEnlace = convertirAModelo(enlaceDTO);
        Enlace enlaceGuardado = enlaceRepository.save(nuevoEnlace);
        return convertirADto(enlaceGuardado);
    }

    // editar un enlace que ya teniamos
    public EnlaceDTO2 actualizarEnlace(Integer id, EnlaceDTO2 enlaceDTO) {
        // primero nos aseguramos que el enlace de verdad exista
        Enlace enlaceExistente = enlaceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no se encontro el enlace con el id " + id));

        // le ponemos los datos nuevos que llegaron
        enlaceExistente.setNombre(enlaceDTO.getNombre());
        enlaceExistente.setUrl(enlaceDTO.getUrl());

        // guardamos y devolvemos la version actualizada
        Enlace enlaceActualizado = enlaceRepository.save(enlaceExistente);
        return convertirADto(enlaceActualizado);
    }

    // borrar un enlace para siempre
    public void eliminarEnlace(Integer id) {
        // igual que antes hay que ver si existe primero
        Enlace enlace = enlaceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no se encontro el enlace con el id " + id));
        enlaceRepository.delete(enlace);
    }
}