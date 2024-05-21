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
    private String address;
    private String name;
    private String service;
    private String description;
    private String nit;
    private String urlImg;

    private List<CitasBasicResponse> citas;
}
