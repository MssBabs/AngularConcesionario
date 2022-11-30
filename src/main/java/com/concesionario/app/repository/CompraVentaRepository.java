package com.concesionario.app.repository;

import com.concesionario.app.domain.CompraVenta;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CompraVenta entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompraVentaRepository extends JpaRepository<CompraVenta, Long> {

    /**
     * count numeroVentas By trabajador.id.
     *
     * @return countNumeroVentasByTrabajador
     */
    @Query("SELECT COUNT(cv) FROM CompraVenta cv WHERE cv.vendedor.id like :id")
    Integer countNumeroVentasByTrabajador(@Param("id") Long id);
}
