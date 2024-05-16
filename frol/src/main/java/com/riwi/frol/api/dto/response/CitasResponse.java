package com.riwi.frol.api.dto.response;

import com.riwi.frol.Util.enums.StateCitas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CitasResponse {
    private Long id;
    private LocalDateTime feha;
    private BigDecimal valor;
    private CompanyToCitaResponse company;
    private ClienteResponse cliente;
    private StateCitas estado;
}
