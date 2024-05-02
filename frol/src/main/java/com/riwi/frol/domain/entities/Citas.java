package com.riwi.frol.domain.entities;

import com.riwi.frol.Util.enums.StateCitas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Entity(name = "citas")
@AllArgsConstructor
@NoArgsConstructor
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate feha;
    @Column(nullable = false)
    private LocalTime hora;
    @Column(nullable = false)
    private double valor;
    private Long id_empresa;
    private Long id_cliente;
    @Enumerated(EnumType.STRING)
    private StateCitas estado;
}
