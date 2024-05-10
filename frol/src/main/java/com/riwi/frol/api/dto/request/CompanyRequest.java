package com.riwi.frol.api.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    private String direccion;
    private String nombre;
    private String servicio;
    private String descripcion;
    private String nit;
    private String urlImg;
    private String email;
    private String password;
}
