package com.riwi.frol.infrastructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.frol.api.dto.request.ClienteRequest;
import com.riwi.frol.api.dto.response.ClienteResponse;
import com.riwi.frol.domain.entities.Cliente;
import com.riwi.frol.domain.repositories.ClienteRepository;
import com.riwi.frol.infrastructure.abstract_services.IClienteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService implements IClienteService{

    private final ClienteRepository objClienteRepository;

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ClienteResponse create(ClienteRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ClienteResponse update(String id, ClienteRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Page<ClienteResponse> getAll(int page, int size) {
        if (page <0) page = 0;
        PageRequest paginable = PageRequest.of(page, size);

        return this.objClienteRepository.findAll(paginable).map(this::entityToResponse);
    }

    private ClienteResponse entityToResponse(Cliente cliente){
        ClienteResponse response = new ClienteResponse();

        BeanUtils.copyProperties(cliente, response);

        
        return response;
    }


}
