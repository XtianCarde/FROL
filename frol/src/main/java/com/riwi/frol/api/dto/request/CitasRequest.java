package com.riwi.frol.api.dto.request;

import com.riwi.frol.Util.enums.StateCitas;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitasRequest {

    @FutureOrPresent(message = "La fecha y hora debe ser futura")
    @NotNull(message = "La fecha y hora de la cita es requeridas")
    private LocalDateTime fecha;
    @NotNull(message = "El precio es requerido")
    @DecimalMin(
            value = "0.01",
            message = "El valor del servicio debe ser mayor a 0"
    )
    private BigDecimal valor;
    @NotNull(message = "El id de la Empresa es obligatorio")
    @Min(value = 1, message = "El id debe ser mayor a cero ")
    private Long id_empresa;
    @NotNull(message = "El id del cliente es obligatorio")
    @Min(value = 1, message = "El id debe ser mayor a cero ")
    private Long id_cliente;
    @NotNull( message = "El rol es requerido")
    private StateCitas estado;
}
