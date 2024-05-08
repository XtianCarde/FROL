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
        Cliente objCliente = this.find(id);

        this.objClienteRepository.delete(objCliente);

    }

    @Override
    public ClienteResponse create(ClienteRequest request) {
        return
    }

    @Override
    public ClienteResponse update(String id, ClienteRequest request) {
        Cliente objCliente = this.find(id);

        Cliente objClienteUpdate = this.clienteRequest(request, objCliente);

        return this.entityToCliente(this.objClienteRepository.save(objClienteUpdate));
    }

    @Override
    public Page<ClienteResponse> getAll(int page, int size) {
        if (page <0) page = 0;

        PageRequest paginable = PageRequest.of(page, size);

        return this.objClienteRepository.findAll(paginable).map(this::entityToCliente);
    }

    
    @Override
    public ClienteResponse getById(String id) {
        return this.entityToCliente(this.find(id));
    }
    
    private ClienteResponse entityToCliente(Cliente entity){
        ClienteResponse response = new ClienteResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }

    private Cliente find(String id){
        return this.objClienteRepository.findById(id).orElseThrow();
    }

    private Cliente clienteRequest (ClienteRequest request, Cliente cliente){
        cliente.setName(request.getName());
        cliente.setPassword(request.getPassworl());
        cliente.setPhone(request.getPhone());
        cliente.setAge(request.getAge());
        return cliente;
    }

}
