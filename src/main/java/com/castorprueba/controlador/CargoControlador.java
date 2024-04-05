package com.castorprueba.controlador;

import com.castorprueba.modelo.Cargo;
import com.castorprueba.servicio.CargoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class CargoControlador {

    private final CargoServicio cargoServicio;

    @GetMapping("/listar-cargos")
    public List<Cargo> listarCargos(){
        return this.cargoServicio.listarCargos();
    }
    @PostMapping("/crear-cargo")
    public ResponseEntity<String> crearECargo(@RequestBody Cargo cargo){
        return this.cargoServicio.crearCargo(cargo);
    }
    @DeleteMapping("/eliminar-cargo/{id}")
    public ResponseEntity<String> eliminarCargo(@PathVariable int id) {
        boolean eliminado = cargoServicio.eliminarCargo(id);
        if (eliminado) {
            return ResponseEntity.ok("Cargo eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cargo no encontrado");
        }
    }
    @PutMapping("/actualizar-cargo/{id}")
    public ResponseEntity<String> actualizarCargo(@PathVariable int id, @RequestBody Cargo cargo){
        boolean actualizado = cargoServicio.actualizarCargo(id, cargo);
        if(actualizado) return ResponseEntity.ok("Cargo actualizado con éxito.");
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cargo no encontrado.");
        }
    }
}
