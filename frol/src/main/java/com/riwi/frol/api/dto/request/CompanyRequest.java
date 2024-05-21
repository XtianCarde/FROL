package com.riwi.frol.api.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    private String address;
    @NotBlank(message = "El nombre de la compañía debe ser requerido")
    @Size(min = 2, max = 100,message = "El nombre de la compañía debe contener entre 2 y 100 carácteres")
    private String name;
    @NotBlank(message = "El servicio de la compañía debe ser requerido")
    private String service;
    @NotBlank(message = "La descripción de la compañía debe ser requerido")
    @Size(min = 15, max = 100,message = "El nombre de la compañía debe contener entre 15 y 100 carácteres")
    private String description;
    @NotBlank(message = "El nit de la compañía debe ser requerido")
    private String nit;
    @NotBlank(message = "Este es el url de img")
    private String urlImg;
    @NotBlank(message = "El email de la compañía debe ser requerido")
    private String email;
    @NotBlank(message = "El password de la compañía debe ser requerido")
    private String password;
}
