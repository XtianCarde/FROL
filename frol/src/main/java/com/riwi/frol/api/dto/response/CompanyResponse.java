package com.riwi.frol.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {
    private Long id;
    private String direccion;
    private String nombre;
    private String servicio;
    private String descripcion;
    private String nit;
    private List<String> citas; //si
}
