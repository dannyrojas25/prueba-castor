package com.castorprueba.servicio;

import com.castorprueba.modelo.Empleado;
import com.castorprueba.repositorio.EmpleadoRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicio {

    private final EmpleadoRepositorio empleadoRepository;

    public EmpleadoServicio(EmpleadoRepositorio empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }
    public ResponseEntity<String> crearEmpleado(Empleado empleado){
        try {
            empleadoRepository.save(empleado);
            return ResponseEntity.ok("Empleado creado con éxito.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la solicitud: " + e.getMessage());
        }
    }
    public boolean actualizarEmpleado(int id, Empleado empleado){
        Optional<Empleado> empleadoExistente = empleadoRepository.findById(id);
        if(empleadoExistente.isPresent()){
            empleado.setId(id);
            empleadoRepository.save(empleado);
            return true;
        }
        return false;
    }
    public boolean eliminarEmpleado(int id) {
        Optional<Empleado> empleadoExistente = empleadoRepository.findById(id);
        if (empleadoExistente.isPresent()) {
            empleadoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
