package com.concesionario.app.service;

import com.concesionario.app.domain.Comision;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Comision}.
 */
public interface ComisionService {

    /**
     * Save a comision.
     *
     * @param comision the entity to save.
     * @return the persisted entity.
     */
    public Comision save(Comision comision);

    /**
     * Get all the comisions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    public Page<Comision> findAll(Pageable pageable);

    /**
     * Get one comision by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Comision> findOne(Long id);

    /**
     * Delete the comision by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id);
}
