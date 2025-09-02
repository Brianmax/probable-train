package com.codigo.spring_boot.repository;

import com.codigo.spring_boot.entity.VuelosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface VueloRepository extends JpaRepository<VuelosEntity, Integer> {

    @Query(nativeQuery = true, value = "select * from vuelos where fecha_salida > :fs and fecha_llegada < :fll")
    List<VuelosEntity> findByFechaSalidaAndFechaLlegada(Date fs, Date fll);
}
