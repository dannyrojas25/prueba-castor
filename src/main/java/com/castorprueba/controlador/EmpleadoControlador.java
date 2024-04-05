package com.castorprueba.controlador;

import com.castorprueba.modelo.Empleado;
import com.castorprueba.servicio.EmpleadoServicio;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class EmpleadoControlador {

    private final EmpleadoServicio empleadoServicio;

    @GetMapping("/listar-empleados")
    public List<Empleado> listarempleados(){
        return this.empleadoServicio.listarEmpleados();
    }
    @PostMapping("/crear-empleado")
    public ResponseEntity<String> crearEmpleado(@RequestBody Empleado empleado){
        return this.empleadoServicio.crearEmpleado(empleado);
    }
    @PutMapping("/actualizar-empleado/{id}")
    public ResponseEntity<String> actualizarEmpleado(@PathVariable int id, @RequestBody Empleado empleado){
        boolean actualizado = empleadoServicio.actualizarEmpleado(id, empleado);
        if(actualizado) return ResponseEntity.ok("Empleado actualizado con éxito.");
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado.");
        }
    }
    @DeleteMapping("/eliminar-empleado/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable int id) {
        boolean eliminado = empleadoServicio.eliminarEmpleado(id);
        if (eliminado) {
            return ResponseEntity.ok("Empleado eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
        }
    }
}
