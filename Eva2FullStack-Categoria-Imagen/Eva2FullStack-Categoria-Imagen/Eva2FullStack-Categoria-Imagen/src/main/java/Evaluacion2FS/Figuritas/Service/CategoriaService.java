package Evaluacion2FS.Figuritas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Evaluacion2FS.Figuritas.DTO.CategoriaDTO;
import Evaluacion2FS.Figuritas.Model.Categoria;
import Evaluacion2FS.Figuritas.Repository.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class CategoriaService {
    @Autowired
        CategoriaRepository categoriaRepository;

    public List<Categoria>obtenerTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria obtenerPorId(Integer id){
        return categoriaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el registro con ID: " + id));
    }


    public List<Categoria> ObtenerStatusTrue() {
        // 1- creamos un objeto para llamar al repo
        List<Categoria>lista=categoriaRepository.findByStatusTrue();
        if(lista.isEmpty()){
            //2- si la lista esta vacia por ejemplo dara este error 
            throw new RuntimeException("No hay categorías que encontrar");
        }
        // como en el paso 1 ya se esta haciendo referencia al metodo de Repository no hace falta llamarlo completamente
        return lista; 
    }

    public List<Categoria>ObtenerStatusFalse(){
        List<Categoria>lista=categoriaRepository.findByStatusFalse();
        if(lista.isEmpty()){
            throw new RuntimeException("No hay categorias que encontrar");
        }
        return lista;
    }

    public String EliminarCategoria(Integer id){
        try {
            Categoria categoria=categoriaRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("No se encontro el registro con ID:"+id));
            categoriaRepository.delete(categoria);
            return "La categoria "+categoria+" a sido eliminada exitosamente";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public Categoria GuardarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria ActualizarCategoria(Integer id,Categoria categoria){
        Categoria cate=categoriaRepository.findById(id)
        .orElseThrow(()->new RuntimeException("No se encontro el registro con ID:"+id));
        if(categoria.getNombre()!=null){
            cate.setNombre(categoria.getNombre());
        }
        if(categoria.getDescripcion()!=null){
            cate.setDescripcion(categoria.getDescripcion());
        }
        if(categoria.getStatus()!=null){
            cate.setStatus(categoria.getStatus());
        }
        return categoriaRepository.save(cate);
    }


    public CategoriaDTO convertirADTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setIdCategoria(categoria.getIdCategoria()); 
        dto.setNombre(categoria.getNombre());
        dto.setDescripcion(categoria.getDescripcion());
        dto.setStatus(categoria.getStatus());
        return dto;
    }

    public List<CategoriaDTO> obtenerTodasDTO() {
        return categoriaRepository.findAll().stream()
            .map(this::convertirADTO)              
            .toList();                             
    }

    public CategoriaDTO obtenerPorID(Integer id){
        log.info("Buscando ID: {}",id);
        Categoria categoria=categoriaRepository.findById(id)
        .orElseThrow(()->{
            log.error("Error:no se encontro la categoria con id{}:",id);
            return new RuntimeException("No se encontro el registro con ID:"+id);
        });
        log.info("Categoria encontrada exitosamente");
        return convertirADTO(categoria);
    }

    

    public List<CategoriaDTO> obtenerStatusTrueDTO(){
        List<Categoria> lista = categoriaRepository.findByStatusTrue();
        if (lista.isEmpty()) {
            log.error("Error:no se han encontrado las categorias.La lista esta vacia");
            throw new RuntimeException("No hay categorias que encontrar");
        }
        log.info("Las categorias se han encontrado");
        return lista.stream()
            .map(this::convertirADTO)
            .toList(); 
    }

    public List<CategoriaDTO>obtenerStatusFalseDTO(){
        List<Categoria>lista=categoriaRepository.findByStatusFalse();
        if(lista.isEmpty()){
            log.error("Error:no se han encontrado las categorias.La lista esta vacia");
            throw  new RuntimeException("No hay categorias que encontrar");
        }
        log.info("Las categorias se han encontrado");
        return lista.stream()
        .map(this::convertirADTO)
        .toList();
    }



}
