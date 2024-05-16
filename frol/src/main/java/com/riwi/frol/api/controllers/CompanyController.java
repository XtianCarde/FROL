package com.riwi.frol.api.controllers;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.riwi.frol.api.dto.request.CompanyRequest;
import com.riwi.frol.api.dto.response.CompanyResponse;
import com.riwi.frol.infrastructure.abstract_services.ICompanyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
@Tag(name = "Compañia")
public class CompanyController {
    private final ICompanyService objICompanyService;

    @Operation(summary = "Lista las compañias por paginación", description = "Muestra la lista de vacantes paginadas en size 10")
    @GetMapping
    public ResponseEntity<Page<CompanyResponse>> get(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.objICompanyService.getAll(page - 1, size));
    }

    @Operation(summary = "Insertar compañias", description = "Agrega nuevas compañias")
    @PostMapping
    public ResponseEntity<CompanyResponse> insert(@Validated @RequestBody CompanyRequest CR) { // falta el validador
        return ResponseEntity.ok(objICompanyService.create(CR));
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
    @Operation(summary = "Eliminar", description = "Elimina compañias por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.objICompanyService.delete(id);
        return ResponseEntity.noContent().build();
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
    @Operation(summary = "Actualizar", description = "Actualiza compañías por id")
    @PutMapping("/{id}")
    public ResponseEntity<CompanyResponse> update(@Validated @PathVariable Long id, @RequestBody CompanyRequest CR) {
        return ResponseEntity.ok(this.objICompanyService.update(id, CR));
    }
}
