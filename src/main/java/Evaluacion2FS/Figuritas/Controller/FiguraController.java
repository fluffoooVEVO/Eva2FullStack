package Evaluacion2FS.Figuritas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Evaluacion2FS.Figuritas.DTO.FiguraDTO;
import Evaluacion2FS.Figuritas.Model.Figura;
import Evaluacion2FS.Figuritas.Service.FiguraService;

@RestController
@RequestMapping("/figura")
public class FiguraController {

    @Autowired
    private FiguraService figuraService;

    @GetMapping
    public ResponseEntity<List<Figura>> obtenerFiguras(){
        List<Figura> figuras=figuraService.obtenerTodos();
        return ResponseEntity.ok(figuras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Figura> obtenerPorId(@PathVariable Integer id_Figura){
        return ResponseEntity.ok(figuraService.obtenerPorId(id_Figura));
    }

    @GetMapping("/{id}/dto")
    public ResponseEntity<FiguraDTO> obtenerDTOporId(@PathVariable Integer id_Figura){
        return ResponseEntity.ok(figuraService.obtenerDTOporId(id_Figura));
    }

    @PostMapping
    public ResponseEntity<Figura> crearFigura(@RequestBody Figura figura){
        return ResponseEntity.ok(figuraService.guardarFigura(figura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Figura> actualizarFigura(@PathVariable Integer id_Figura, @RequestBody Figura figura){
        return ResponseEntity.ok(figuraService.actualizarFigura(id_Figura, figura));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarFigura(@PathVariable Integer id_Figura){
        return ResponseEntity.ok(figuraService.eliminarFigura(id_Figura));
    }

}
