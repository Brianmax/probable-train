package com.codigo.spring_boot.repository;

import com.codigo.spring_boot.entity.VueloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface VueloRepository extends JpaRepository<VueloEntity, Integer> {

    @Query(nativeQuery = true, value = "select * from vuelos where fecha_salida > :fs and fecha_llegada < :fll")
    List<VueloEntity> findByFechaSalidaAndFechaLlegada(Date fs, Date fll);
}
