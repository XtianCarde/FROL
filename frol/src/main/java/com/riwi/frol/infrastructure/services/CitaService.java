package com.riwi.frol.infrastructure.services;

import com.riwi.frol.Util.exceptions.BadRequestException;
import com.riwi.frol.api.dto.request.CitasRequest;
import com.riwi.frol.api.dto.response.CitasResponse;
import com.riwi.frol.api.dto.response.ClienteResponse;
import com.riwi.frol.api.dto.response.CompanyToCitaResponse;
import com.riwi.frol.domain.entities.Cita;
import com.riwi.frol.domain.entities.Cliente;
import com.riwi.frol.domain.entities.Company;
import com.riwi.frol.domain.repositories.CitaRepository;
import com.riwi.frol.domain.repositories.ClienteRepository;
import com.riwi.frol.domain.repositories.CompanyRepository;
import com.riwi.frol.infrastructure.abstract_services.ICitaService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentMap;

@Service
@Transactional
@AllArgsConstructor
public class CitaService implements ICitaService {

    @Autowired
    private final CitaRepository citaRepository;

    @Autowired
    private final ClienteRepository clienteRepository;

    @Autowired
    private final CompanyRepository companyRepository;

    @Override
    public void delete(Long id) {
        this.citaRepository.delete(this.find(id));
    }

    @Override
    public CitasResponse create(CitasRequest request) {

        //obtener Clientes
        Cliente client = this.clienteRepository.findById(request.getClienteId())
                .orElseThrow(()-> new BadRequestException("No hay clientes con el id suministrado"));

        //Obtener Companias
        Company compaia = this.companyRepository.findById(request.getEmpresaId())
                .orElseThrow(()-> new BadRequestException("No hay empresas con el id suministrado"));



        Cita cita = this.requestToCita(request);

        cita.setCliente(client);
        cita.setCompany(compaia);

        return this.citasToResponse(this.citaRepository.save(cita));
    }

    @Override
    public CitasResponse update(Long id, CitasRequest request) {

        Cita cita = this.find(id);
        // Obtener cliente
        Cliente client = this.clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new BadRequestException("No hay clientes con el id suministrado"));

        // Obtener cliente
        Company empresa = this.companyRepository.findById(request.getEmpresaId())
                .orElseThrow(() -> new BadRequestException("No hay empleados con el id suministrado"));


        cita = this.requestToCita(request);

        cita.setCliente(client);
        cita.setCompany(empresa);
        cita.setId(id);

        return this.citasToResponse(this.citaRepository.save(cita));
    }


    @Override
    public Page<CitasResponse> getAll(int page, int size) {
        if(page < 0){
            page = 0;
        }

        PageRequest pagination = PageRequest.of(page,size);

        return this.citaRepository.findAll(pagination).map(this::citasToResponse);
    }



    private CitasResponse citasToResponse(Cita entity){

        ClienteResponse cliente = new ClienteResponse();
        BeanUtils.copyProperties(entity.getCliente(),cliente);

        CompanyToCitaResponse compania = new CompanyToCitaResponse();
        BeanUtils.copyProperties(entity.getCompany(),compania);

        return CitasResponse.builder()
                .id(entity.getId())
                .feha(entity.getFeha())
                .valor(entity.getValor())
                .cliente(cliente)
                .estado(entity.getEstado())
                .company(compania)
                .build();

    }

    private Cita requestToCita(CitasRequest request){
        return Cita.builder()
                .feha(request.getFecha())
                .estado(request.getEstado())
                .valor(request.getValor())
                .build();
    }


    private Cita find(Long id){
        return this.citaRepository.findById(id).orElseThrow(()-> new BadRequestException("No hay citas con el id suministrado"));
    }


}
