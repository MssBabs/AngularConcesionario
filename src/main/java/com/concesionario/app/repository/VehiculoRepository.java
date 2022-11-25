package com.concesionario.app.repository;

import com.concesionario.app.domain.Vehiculo;
import com.concesionario.app.domain.enumeration.Tipo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Vehiculo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    /**
     * Get vehiculos by Types.
     *
     * @param pageable
     * @return getTypes
     */
    @Query("SELECT v FROM Vehiculo v WHERE v.tipo like :tipo")
    Page<Vehiculo> getvehiclesByType(@Param("tipo") Tipo tipoVehiculo, Pageable pageable);
}
