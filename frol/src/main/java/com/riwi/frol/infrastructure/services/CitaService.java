package com.riwi.frol.infrastructure.services;

import com.riwi.frol.api.dto.request.CitasRequest;
import com.riwi.frol.api.dto.response.CitasResponse;
import com.riwi.frol.domain.repositories.CitaRepository;
import com.riwi.frol.infrastructure.abstract_services.ICitaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CitaService implements ICitaService {

    @Autowired
    private final CitaRepository citaRepository;

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public CitasResponse create(CitasRequest request) {
        return null;
    }

    @Override
    public CitasResponse update(Long aLong, CitasRequest request) {
        return null;
    }

    @Override
    public Page<CitasResponse> getAll(int page, int size) {
        return null;
    }

    @Override
    public CitasResponse getById(Long id) {
        return null;
    }
}
