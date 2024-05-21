package com.riwi.frol.api.controllers;

import com.riwi.frol.api.dto.request.CitasRequest;
import com.riwi.frol.api.dto.response.CitasResponse;
import com.riwi.frol.infrastructure.abstract_services.ICitaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cita")
@AllArgsConstructor
@CrossOrigin("*")
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

    @Operation(summary = "Insertar Citas", description = "Agrega nuevas Citas")
    @PostMapping
    public ResponseEntity<CitasResponse> insert(
            @Validated
            @RequestBody CitasRequest request){
        return  ResponseEntity.ok(this.objCitaService.create(request));
    }

    
    @ApiResponse(
        responseCode = "400",
        description = "Cuando el id no es válido",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)
            )
        }
    )
    @Operation(summary = "Eliminar", description = "Elimina Citas por id")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.objCitaService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @ApiResponse(responseCode = "400", description = "Cuando el id no es válido", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(summary = "Actualizar", description = "Actualiza Citas por id")
    @PutMapping(path = "/{id}")
    public ResponseEntity<CitasResponse> update(
            @Validated @RequestBody CitasRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.objCitaService.update(id,request));
    }
}
