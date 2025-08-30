package com.codigo.spring_boot.repository;

import com.codigo.spring_boot.entity.AerolineaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AerolineaRepository extends JpaRepository<AerolineaEntity, Integer> {
}
