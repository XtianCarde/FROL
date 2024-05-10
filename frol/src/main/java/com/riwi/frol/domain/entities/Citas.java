package com.riwi.frol.domain.entities;

import com.riwi.frol.Util.enums.StateCitas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Data
@Entity(name = "citas")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime feha;
    @Column(nullable = false)
    private BigDecimal valor;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa" , referencedColumnName = "id")
    private Long id_empresa;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente" , referencedColumnName = "id")
    private Long id_cliente;

    @Enumerated(EnumType.STRING)
    private StateCitas estado;
}
