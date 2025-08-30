package com.codigo.spring_boot.repository;

import com.codigo.spring_boot.entity.AvionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<AvionEntity, Integer> {
}
