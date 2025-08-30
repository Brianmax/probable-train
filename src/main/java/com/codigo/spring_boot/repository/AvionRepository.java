package com.codigo.spring_boot.repository;

import com.codigo.spring_boot.entity.AvionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvionRepository extends JpaRepository<AvionEntity, Integer> {
    @Query(nativeQuery = true, value = "select * from aviones where capacidad between :min and :max")
    List<AvionEntity> findByMinMaxCapacity(int min, int max);
}
