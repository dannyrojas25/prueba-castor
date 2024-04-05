package com.castorprueba.servicio;

import com.castorprueba.modelo.Cargo;
import com.castorprueba.repositorio.CargoRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoServicio {
    private final CargoRepositorio cargoRepositorio;

    public CargoServicio(CargoRepositorio cargoRepository) {
        this.cargoRepositorio = cargoRepository;
    }
    public List<Cargo> listarCargos() {
        return cargoRepositorio.findAll();
    }
    public ResponseEntity<String> crearCargo(Cargo cargo){
        try {
            cargoRepositorio.save(cargo);
            return ResponseEntity.ok("Cargo creado con éxito.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la solicitud: " + e.getMessage());
        }
    }
    public boolean actualizarCargo(int id, Cargo cargo){
        Optional<Cargo> cargoxistente = cargoRepositorio.findById(id);
        if(cargoxistente.isPresent()){
            cargo.setId(id);
            cargoRepositorio.save(cargo);
            return true;
        }
        return false;
    }
    public boolean eliminarCargo(int id) {
        Optional<Cargo> cargoExistente = cargoRepositorio.findById(id);
        if (cargoExistente.isPresent()) {
            cargoRepositorio.deleteById(id);
            return true;
        }
        return false;
    }

}
