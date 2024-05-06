package com.riwi.frol.infrastructure.abstract_services;

import com.riwi.frol.api.dto.request.CompanyRequest;
import com.riwi.frol.api.dto.response.CompanyResponse;

public interface ICompanyService extends CrudService<CompanyResponse, CompanyRequest,Long> {
    
}
