package com.riwi.frol.api.controllers;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {
    private final ICompanyService objICompanyService;

    @GetMapping
    public ResponseEntity<Page<CompanyResponse>> get(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(this.objICompanyService.getAll(page - 1, size));
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> insert(@RequestBody CompanyRequest CR) { // falta el validador
        return ResponseEntity.ok(objICompanyService.create(CR));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.objICompanyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyResponse> update(@PathVariable Long id, @RequestBody CompanyRequest CR) {
        return ResponseEntity.ok(this.objICompanyService.update(id, CR));
    }
}
