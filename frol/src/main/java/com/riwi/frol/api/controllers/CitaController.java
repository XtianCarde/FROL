package com.riwi.frol.api.controllers;

import com.riwi.frol.api.dto.request.CitasRequest;
import com.riwi.frol.api.dto.response.CitasResponse;
import com.riwi.frol.infrastructure.abstract_services.ICitaService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
            summary = "Lista todas las citas, con su respectiva compañia y cliente",
            description = "Debes enviar la pagina y el tamaño de la pagina para recibir todas las vacantes"
    )
    @GetMapping
    public ResponseEntity<Page<CitasResponse>> getAll(
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

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.objCitaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CitasResponse> update(
            @Validated @RequestBody CitasRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.objCitaService.update(id,request));
    }
}
