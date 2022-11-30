package com.concesionario.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concesionario.app.service.dto.TrabajadorDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link TrabajadorDTO}.
 */
public interface TrabajadorDTOService {

    /**
     * Get all the trabajadorsDTO.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TrabajadorDTO> findAll(Pageable pageable);

    /**
     * Get the "id" trabajadorDTO.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TrabajadorDTO> findOne(Long id);
}
