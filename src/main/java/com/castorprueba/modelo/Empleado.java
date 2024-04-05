package com.castorprueba.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empelado")
    private int id;

    private int cedula;
    private String nombre;
    private String foto;
    Date fechaIngreso;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "empleado_cargo", joinColumns = @JoinColumn(name = "empleado_id", referencedColumnName = "id_empelado")
            ,inverseJoinColumns = @JoinColumn(name = "cargo_id", referencedColumnName = "id_cargo"))
    private List<Cargo> cargos = new ArrayList<>();
}
