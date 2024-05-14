package com.riwi.frol.infrastructure.services;

import com.riwi.frol.api.dto.request.CitasRequest;
import com.riwi.frol.api.dto.response.CitasResponse;
import com.riwi.frol.api.dto.response.ClienteResponse;
import com.riwi.frol.domain.entities.Cita;
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
    public void delete(Long aLong) {

    }

    @Override
    public CitasResponse create(CitasRequest request) {
        Cita objCita = this.citaRequesr(request,new Cita());

        return this.citasToResponse(this.citaRepository.save(objCita));
    }

    @Override
    public CitasResponse update(Long aLong, CitasRequest request) {
        return null;
    }

    @Override
    public Page<CitasResponse> getAll(int page, int size) {
        if(page < 0){
            page = 0;
        }

        PageRequest pagination = PageRequest.of(page,size);

        return this.citaRepository.findAll(pagination).map(this::citasToResponse);
    }

    @Override
    public CitasResponse getById(Long id) {
        return null;
    }

    private CitasResponse citasToResponse(Cita entity){
        CitasResponse response = new CitasResponse();

        BeanUtils.copyProperties(entity,response);

        return  response;
    }

    private Cita citaRequesr (CitasRequest request , Cita cita){
        cita.setEstado(request.getEstado());
        cita.setFeha(request.getFecha());
        cita.setValor(request.getValor());
       /* cita.setId_cliente(request.getId_cliente());
        cita.setId_empresa(request.getId_empresa());*/
        return cita;
    }
}
