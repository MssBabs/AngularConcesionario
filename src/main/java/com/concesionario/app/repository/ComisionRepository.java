package com.concesionario.app.repository;

import com.concesionario.app.domain.Comision;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Comision entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ComisionRepository extends JpaRepository<Comision, Long> {

    /**
     * assign a comision trabajador By numeroVentas.
     *
     * @return assignComisionTrabajadorBynumeroVentas
     */
    @Query("SELECT MIN(c.porciento) FROM Comision c WHERE c.numeroVentas >= :numeroVentas")
    Float assignComisionTrabajadorByNumeroVentas(@Param("numeroVentas") Integer numeroVentas);
}
