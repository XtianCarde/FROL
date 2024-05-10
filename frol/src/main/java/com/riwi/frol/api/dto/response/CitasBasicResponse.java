package com.riwi.frol.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CitasBasicResponse {
    private Long id;
    private String nombre;
    private String servicio;
    private String descripcion; // aca van los atributos de la cita
}
