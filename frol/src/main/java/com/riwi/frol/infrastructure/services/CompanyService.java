package com.riwi.frol.infrastructure.services;

import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.riwi.frol.Util.exceptions.IdNotFoundException;
import com.riwi.frol.api.dto.request.CompanyRequest;
import com.riwi.frol.api.dto.response.CitasBasicResponse;
import com.riwi.frol.api.dto.response.CompanyResponse;
import com.riwi.frol.domain.entities.Cita;
import com.riwi.frol.domain.entities.Company;
import com.riwi.frol.domain.repositories.CompanyRepository;
import com.riwi.frol.infrastructure.abstract_services.ICompanyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    @Autowired
    private final CompanyRepository companyRepository;

    @Override
    public void delete(Long id) {
        Company company = this.find(id);
        this.companyRepository.delete(company);
    }

    @Override
    public CompanyResponse create(CompanyRequest rq) {
        Company company = this.requestToCompany(rq, new Company());
        return this.entityToResponse(this.companyRepository.save(company));
    }

    @Override
    public CompanyResponse update(Long id, CompanyRequest rq) {
        Company company = this.find(id);
        Company companyUpdate = this.requestToCompany(rq,company);
        return this.entityToResponse(this.companyRepository.save(companyUpdate));
    }

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        
        PageRequest pageable = PageRequest.of(page, size);

        return this.companyRepository.findAll(pageable)
            .map(this::entityToResponse);
    }

    private Company find(Long id){
        return this.companyRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Company"));
    }

    private CompanyResponse entityToResponse(Company company){
        CompanyResponse companyResponse = new CompanyResponse();
        BeanUtils.copyProperties(company, companyResponse);
        companyResponse.setCitas(company.getCitas()
        .stream()
        .map(this::citaToResponse)
        .collect(Collectors.toList()));
        return companyResponse;
    }

    private Company requestToCompany(CompanyRequest CR, Company company){
        BeanUtils.copyProperties(CR, company);
        company.setCitas(new ArrayList<>());
        return company;
    }
    
    private CitasBasicResponse citaToResponse(Cita entity){
        CitasBasicResponse response = new CitasBasicResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
