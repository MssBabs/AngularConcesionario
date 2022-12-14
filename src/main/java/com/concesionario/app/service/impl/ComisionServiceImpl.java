package com.concesionario.app.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.concesionario.app.domain.Comision;
import com.concesionario.app.repository.ComisionRepository;
import com.concesionario.app.service.ComisionService;

import java.util.Optional;


/**
 * Service Implementation for managing {@link Comision}.
 */
@Service
@Transactional
public class ComisionServiceImpl implements ComisionService{

    private final Logger log = LoggerFactory.getLogger(ComisionServiceImpl.class);

    private final ComisionRepository comisionRepository;


    public ComisionServiceImpl(ComisionRepository comisionRepository) {
        this.comisionRepository = comisionRepository;
    }


    /**
     * Save a comision.
     *
     * @param comision the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Comision save(Comision comision) {
        log.debug("Request to save Comision : {}", comision);
        return comisionRepository.save(comision);
    }

    /**
     * Get all the comisions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Comision> findAll(Pageable pageable) {
        log.debug("Request to get all Comisions");
        return comisionRepository.findAll(pageable);
    }


    /**
     * Get one comision by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Comision> findOne(Long id) {
        log.debug("Request to get Comision : {}", id);
        return comisionRepository.findById(id);
    }

    /**
     * Delete the comision by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Comision : {}", id);
        comisionRepository.deleteById(id);
    }
}
