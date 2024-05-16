package com.riwi.frol.domain.repositories;

import com.riwi.frol.domain.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Long>{

//    @Query("SELECT COUNT(a) FROM citas a WHERE a.feha = :fecha")
//    public Long countByCitaIdAndDataTime(@Param("fecha")LocalDateTime fecha);
}
