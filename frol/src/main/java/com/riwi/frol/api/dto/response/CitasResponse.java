package com.riwi.frol.api.dto.response;

import com.riwi.frol.Util.enums.StateCitas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CitasResponse {
    private Long id;
    private LocalDate feha;
    private LocalTime hora;
    private double valor;
    private Long id_empresa;
    private Long id_cliente;
    private StateCitas estado;
}
