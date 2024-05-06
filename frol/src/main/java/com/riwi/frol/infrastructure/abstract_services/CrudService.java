package com.riwi.frol.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface CrudService<RS, RQ, ID> {
    
    void delete(ID id);
    
    RS create(RQ rq);

    RS update(ID id, RQ rq);

    Page<RS> getAll(int page, int size);

}
