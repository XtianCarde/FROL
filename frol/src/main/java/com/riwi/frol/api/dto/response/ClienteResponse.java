package com.riwi.frol.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponse {
    private Long id;
    private String name;
    private String passworl;
    private String email;
    private int age;
    private int phone; 
}
