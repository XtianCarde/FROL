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
    public void delete(Long id) {
        Cliente objCliente = this.find(Long.valueOf(id));

        this.objClienteRepository.delete(objCliente);

    }

    @Override
    public ClienteResponse create(ClienteRequest request) {
        return null;
    }

    @Override
    public ClienteResponse update(Long id, ClienteRequest request) {
        Cliente objCliente = this.find(Long.valueOf(id));

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
    public ClienteResponse getById(Long id) {
        return this.entityToCliente(this.find(Long.valueOf(id)));
    }
    
    private ClienteResponse entityToCliente(Cliente entity){
        ClienteResponse response = new ClienteResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }

    private Cliente find(Long id){
        return this.objClienteRepository.findById(id).orElseThrow();
    }

    private Cliente clienteRequest (ClienteRequest request, Cliente cliente){
        cliente.setName(request.getName());
        cliente.setPassword(request.getPassworl());
        cliente.setEmail(request.getEmail());
        // cliente.setPhone(request.getPhone());
        // cliente.setAge(request.getAge());
        return cliente;
    }

}
