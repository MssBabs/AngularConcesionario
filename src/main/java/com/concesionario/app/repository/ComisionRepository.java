package com.concesionario.app.repository;

import com.concesionario.app.domain.Comision;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Comision entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ComisionRepository extends JpaRepository<Comision, Long> {

}
