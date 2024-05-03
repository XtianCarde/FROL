package com.riwi.frol.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

<<<<<<< HEAD
/*
RQ = REQUEST
RS = RESPONSE
ID = Tipo de dato de la llave primaria dela entidad
*/
public interface CrudService<RQ,RS,ID> {
    public void delete(ID id);
    public RS create(RQ request);
    public RS update(ID id, RQ request);
    public Page<RS> getAll(int page,int size);
}
=======
public interface CrudService<RQ, RS, ID> {

    public void delete(ID id);

    public RS create(RQ request);

    public RS update(ID id, RQ request);

    public Page<RS> getAll(int page, int size);
}
>>>>>>> 05cd058f93c53c80e9dd9a7f0968a4fbd2b8828a
