package com.riwi.frol.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.frol.api.dto.request.ClienteRequest;
import com.riwi.frol.api.dto.response.ClienteResponse;
import com.riwi.frol.infrastructure.abstract_services.IClienteService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {
    @Autowired
    private final IClienteService objClienteService;
    
/*
    @Operation(summary = "Lista todas los clientes con paginación",
    description = "Debes enviar la pagina y el tamaño de la pagina para recibir todas la vacantes correspondientes")
    @GetMapping
    public ResponseEntity<Page<ClienteResponse>>     (
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size) {
            
            return ResponseEntity.ok(this.objClienteService.getAll(page -1, size));
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(this.objClienteService.getById(Long.valueOf(id)));
    }

    @Operation(summary = "Crea una vacante y la asocia una compañia", description = "Crea un cliente y la asocia una compañia")
    @PostMapping
    public ResponseEntity<ClienteResponse> insert (
        @Validated 
        @RequestBody ClienteRequest request){
        return ResponseEntity.ok(this.objClienteService.create(request));
    }

    @Operation(summary = "Elimina una vacante por Id", description = "Elimina un cliente por Id")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String,String>> delete(@PathVariable String id){
        this.objClienteService.delete(Long.valueOf(id));

        Map<String,String> response = new HashMap<>();

        response.put("messages", "Se elimino el cliente Correctamente");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Actualiza una cuenta de cliente", description = "Actualiza un cliente")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> update(@PathVariable Long id,
    @Validated @RequestBody ClienteRequest cliente){
        return ResponseEntity.ok(this.objClienteService.update(id, cliente));
    }
}
