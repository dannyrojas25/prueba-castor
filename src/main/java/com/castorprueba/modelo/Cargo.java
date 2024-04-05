package com.castorprueba.modelo;

import jakarta.persistence.*;
import lombok.*;
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private int id;

    private String nombre;
}
