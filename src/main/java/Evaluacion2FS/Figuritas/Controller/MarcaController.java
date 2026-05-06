package Evaluacion2FS.Figuritas.Controller;

import Evaluacion2FS.Figuritas.DTO.MarcaDTO2;
import Evaluacion2FS.Figuritas.Service.MarcaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// con esto le decimos a spring que este archivo va a recibir las peticiones de internet (postman)
@RestController
// esta es la ruta base. todas las peticiones a /api/v1/marcas van a caer aca
@RequestMapping("/api/v1/marcas")
public class MarcaController {

    // traemos el servicio
    @Autowired
    private MarcaService marcaService;

    // getmapping es para cuando queremos leer o pedir datos (metodo GET en postman)
    @GetMapping
    public ResponseEntity<List<MarcaDTO2>> listarMarcas() {
        List<MarcaDTO2> marcas = marcaService.obtenerTodas();
        // devolvemos la lista de marcas y un codigo 200 que significa que salio todo bien
        return new ResponseEntity<>(marcas, HttpStatus.OK);
    }

    // aca le pasamos un id por la url para buscar una marca especifica
    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO2> obtenerMarca(@PathVariable Integer id) {
        MarcaDTO2 marca = marcaService.buscarPorId(id);
        return new ResponseEntity<>(marca, HttpStatus.OK);
    }

    // postmapping es para cuando queremos guardar algo nuevo en la bd
    // el @Valid activa las validaciones que le pusimos al dto (que no venga vacio)
    @PostMapping
    public ResponseEntity<MarcaDTO2> crearMarca(@Valid @RequestBody MarcaDTO2 marcaDTO) {
        MarcaDTO2 nuevaMarca = marcaService.guardarMarca(marcaDTO);
        // devolvemos un 201 que significa "creado exitosamente"
        return new ResponseEntity<>(nuevaMarca, HttpStatus.CREATED);
    }

    // putmapping es para editar algo que ya existe
    @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO2> actualizarMarca(@PathVariable Integer id, @Valid @RequestBody MarcaDTO2 marcaDTO) {
        MarcaDTO2 marcaActualizada = marcaService.actualizarMarca(id, marcaDTO);
        return new ResponseEntity<>(marcaActualizada, HttpStatus.OK);
    }

    // deletemapping obviamente es para borrar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMarca(@PathVariable Integer id) {
        marcaService.eliminarMarca(id);
        // el 204 significa que salio bien pero que no hay nada que devolver en la pantalla
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}