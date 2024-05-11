package com.riwi.frol.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {
    @Size(min = 0,max = 40, message = "El nombre  supera la cantidad de caracteres  permitidos")
    @NotBlank(message = "El nombre del cliente debe ser requerido")
    private String name;
    @Size(min = 0,max = 16, message = "La contraseña supera la cantidad de caracteres permitidos")
    @NotBlank(message = "La contraseña del cliente debe ser requerido")
    private String passworl;
    @Email
    private String email;
    // @Positive
    // @NotBlank(message = "La edad del cliente debe ser requerido")
    // private int age;
    // @NotBlank(message = "El numero del cliente debe ser requerido")
    // private String phone;
}
