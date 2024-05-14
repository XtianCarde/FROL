package com.riwi.frol.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CitasBasicResponse {
    private Long id;
    private LocalDateTime fecha;
    private String nombre;
}
