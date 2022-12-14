package com.concesionario.app.service.impl;

import com.concesionario.app.service.TrabajadorService;
import com.concesionario.app.domain.Trabajador;
import com.concesionario.app.repository.TrabajadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Trabajador}.
 */
@Service
@Transactional
public class TrabajadorServiceImpl implements TrabajadorService {

    private final Logger log = LoggerFactory.getLogger(TrabajadorServiceImpl.class);

    private final TrabajadorRepository trabajadorRepository;

    public TrabajadorServiceImpl(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    /**
     * Save a trabajador.
     *
     * @param trabajador the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Trabajador save(Trabajador trabajador) {
        log.debug("Request to save Trabajador : {}", trabajador);
        return trabajadorRepository.save(trabajador);
    }

    /**
     * Get all the trabajadors.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Trabajador> findAll(Pageable pageable) {
        log.debug("Request to get all Trabajadors");
        return trabajadorRepository.findAll(pageable);
    }


    /**
     * Get one trabajador by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Trabajador> findOne(Long id) {
        log.debug("Request to get Trabajador : {}", id);
        return trabajadorRepository.findById(id);
    }

    /**
     * Delete the trabajador by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Trabajador : {}", id);
        trabajadorRepository.deleteById(id);
    }
}
