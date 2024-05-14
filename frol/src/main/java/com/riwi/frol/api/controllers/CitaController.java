package com.riwi.frol.api.controllers;

import com.riwi.frol.api.dto.request.CitasRequest;
import com.riwi.frol.api.dto.response.CitasResponse;
import com.riwi.frol.infrastructure.abstract_services.ICitaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cita")
@AllArgsConstructor
public class CitaController {

    @Autowired
    private final ICitaService objCitaService;

    @GetMapping
    public ResponseEntity<Page<CitasResponse>> get(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size
    ){
        return  ResponseEntity.ok(this.objCitaService.getAll(page -1,size));
    }

    @PostMapping
    public ResponseEntity<CitasResponse> insert(
            @Validated
            @RequestBody CitasRequest request){
        return  ResponseEntity.ok(this.objCitaService.create(request));
    }
}
