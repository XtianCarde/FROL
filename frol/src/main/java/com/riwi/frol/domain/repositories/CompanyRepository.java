package com.riwi.frol.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.frol.domain.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}
