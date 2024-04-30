package com.riwi.frol.api.dto.request;

import com.riwi.frol.Util.enums.StateCitas;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitasRequest {
    private LocalDate feha;
    private LocalTime hora;
    private double valor;
    private Long id_empresa;
    private Long id_cliente;
    private StateCitas estado;
}
