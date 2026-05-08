package Evaluacion2FS.Figuritas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Evaluacion2FS.Figuritas.Model.Figuras;
import Evaluacion2FS.Figuritas.Service.FigurasService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/Figuras")
public class FigurasController {

    @Autowired
    private FigurasService figurasService;

    @GetMapping
    public ResponseEntity<List<Figuras>> obtenerFiguras(){
        List<Figuras> figuras=figurasService.obtenerTodos();
        return ResponseEntity.ok(figuras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Figuras> obtenerFigsPorId(@PathVariable Integer id_producto_figura){
        return ResponseEntity.ok(figurasService.obtenerPorId(id_producto_figura));
    } 
    
    @PostMapping
    public ResponseEntity<Figuras> crearFiguras(@RequestBody Figuras figuras){
        return ResponseEntity.ok(figurasService.guardarFigura(figuras));
    }

    @PutMapping("/{id}")
        public ResponseEntity<Figuras> actualizarFiguras(@PathVariable Integer id_producto_figura, @RequestBody Figuras figuras){
            return ResponseEntity.ok(figurasService.actualizarFigura(id_producto_figura, figuras));
        }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarFiguras(@PathVariable Integer id_producto_figura){
        return ResponseEntity.ok(figurasService.eliminarFigura(id_producto_figura));
    }


}
