package com.riwi.frol.domain.entities;

import com.riwi.frol.Util.enums.StateCitas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;



@Data
@Entity(name = "citas")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime feha;
    @Column(nullable = false)
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private StateCitas estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa" , referencedColumnName = "id")
    private Company id_empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente" , referencedColumnName = "id")
    private Cliente id_cliente;


}
