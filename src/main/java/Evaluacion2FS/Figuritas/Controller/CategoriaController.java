package Evaluacion2FS.Figuritas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Evaluacion2FS.Figuritas.DTO.CategoriaDTO;
import Evaluacion2FS.Figuritas.Service.CategoriaService;

@RestController
@RequestMapping("api/v1/Figuritas")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAll() {
        List<CategoriaDTO> categorias = categoriaService.obtenerTodasDTO();
        if (categorias.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Integer id) {
        try {
            CategoriaDTO categoria = categoriaService.obtenerPorID(id);
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categorias-true")
    public ResponseEntity<List<CategoriaDTO>> getStatusTrue() {
        try {
            List<CategoriaDTO> categorias = categoriaService.obtenerStatusTrueDTO();
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/categorias-false")
    public ResponseEntity<List<CategoriaDTO>> getStatusFalse() {
        try {
            List<CategoriaDTO> categorias = categoriaService.obtenerStatusFalseDTO();
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> guardarCategoria(@RequestBody CategoriaDTO dto) {
        CategoriaDTO guardada = categoriaService.guardarCategoriaDTO(dto);
        return new ResponseEntity<>(guardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> actualizarCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO dto) {
        try {
            CategoriaDTO actualizada = categoriaService.actualizarCategoriaDTO(id, dto);
            return new ResponseEntity<>(actualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Integer id) {
        try {
            String mensaje = categoriaService.eliminarCategoriaDTO(id);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
