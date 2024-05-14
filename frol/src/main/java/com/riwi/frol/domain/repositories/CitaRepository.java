package com.riwi.frol.domain.repositories;

import com.riwi.frol.domain.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Long>{
}
