package Evaluacion2FS.Figuritas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Evaluacion2FS.Figuritas.DTO.CategoriaDTO;
import Evaluacion2FS.Figuritas.Model.Categoria;
import Evaluacion2FS.Figuritas.Service.CategoriaService;



@RestController
@RequestMapping("api/v1/Figuritas")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>>GetAll(){
        List<CategoriaDTO>categorias=categoriaService.obtenerTodasDTO();
        if(categorias.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO>BuscarPorId(@PathVariable Integer id){
        try {
            CategoriaDTO categoria=categoriaService.obtenerPorID(id);
            return new ResponseEntity<>(categoria,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/CategoriasTrue")
    public ResponseEntity<List<CategoriaDTO>>GetStatusTrue(){
        List<CategoriaDTO>categorias=categoriaService.obtenerStatusTrueDTO();
        if(categorias.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/CategoriasFalse")
    public ResponseEntity<List<CategoriaDTO>>GetStatusFalse(){
        List<CategoriaDTO>categorias=categoriaService.obtenerStatusFalseDTO();
        if(categorias.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> actualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        try {
            Categoria actualizada = categoriaService.ActualizarCategoria(id, categoria);
            CategoriaDTO dto = categoriaService.convertirADTO(actualizada);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminarCategoria(@PathVariable Integer id){
        String dato=categoriaService.EliminarCategoria(id);
        if(dato.contains("exitosamente")){
            return new ResponseEntity<>(dato,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(dato,HttpStatus.NOT_FOUND);
        }
    }
}
