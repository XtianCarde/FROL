package com.riwi.frol.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.frol.domain.entities.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente,String>{    
}
