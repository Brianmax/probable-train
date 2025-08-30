package com.codigo.spring_boot.repository;

import com.codigo.spring_boot.entity.PilotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotoRepository extends JpaRepository<PilotoEntity, Integer> {
}
