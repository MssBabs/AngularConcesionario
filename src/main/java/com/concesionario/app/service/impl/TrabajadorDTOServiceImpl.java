package com.concesionario.app.service.impl;

import com.concesionario.app.domain.Trabajador;
import com.concesionario.app.repository.ComisionRepository;
import com.concesionario.app.repository.CompraVentaRepository;
import com.concesionario.app.repository.TrabajadorRepository;
import com.concesionario.app.service.TrabajadorDTOService;
import com.concesionario.app.service.dto.TrabajadorDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Vehiculo}.
 */
@Service
@Transactional
public class TrabajadorDTOServiceImpl implements TrabajadorDTOService {

    private final Logger log = LoggerFactory.getLogger(TrabajadorDTOServiceImpl.class);

    private final TrabajadorRepository trabajadorRepository;
    private final ComisionRepository comisionRepository;
    private final CompraVentaRepository compraVentaRepository;

    public TrabajadorDTOServiceImpl(    TrabajadorRepository trabajadorRepository,
                                        ComisionRepository comisionRepository,
                                        CompraVentaRepository compraVentaRepository) {
        this.trabajadorRepository = trabajadorRepository;
        this.comisionRepository = comisionRepository;
        this.compraVentaRepository = compraVentaRepository;
    }


    /**
     * Get all the trabajadorsDTO.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TrabajadorDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TrabajadorDTO");

        Page<Trabajador> trabajadores=trabajadorRepository.findAll(pageable);

        return trabajadores.map(this::fromEntityToDTO);
    }

    /**
     * Get one trabajadorDTO by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TrabajadorDTO> findOne(Long id) {
        log.debug("Request to get TrabajadorDTO : {}", id);

        Optional<TrabajadorDTO> trabajadoresDTOOptional = Optional.empty();

        Optional<Trabajador> trabajadorEntityOptional=trabajadorRepository.findById(id);

        if(trabajadorEntityOptional.isPresent()){

            TrabajadorDTO trabajadorDTO =fromEntityToDTO(trabajadorEntityOptional.get());

            trabajadoresDTOOptional= Optional.of(trabajadorDTO);
        }

        return trabajadoresDTOOptional;
    }


    private TrabajadorDTO fromEntityToDTO(Trabajador trabajador){
        TrabajadorDTO trabajadorDTO = new TrabajadorDTO();

        trabajadorDTO.setId(trabajador.getId());
        trabajadorDTO.setDni(trabajador.getDni());
        trabajadorDTO.setApellido(trabajador.getApellido());
        trabajadorDTO.setNombre(trabajador.getNombre());
        trabajadorDTO.setCargo(trabajador.getCargo());
        trabajadorDTO.setTelefono(trabajador.getTelefono());

        Integer numVentas=compraVentaRepository.countNumeroVentasByTrabajador(trabajador.getId());
        trabajadorDTO.setNumeroVentas(numVentas);

        Float comision=comisionRepository.assignComisionTrabajadorByNumeroVentas(numVentas);
        trabajadorDTO.setComision(comision);

        return trabajadorDTO;
    }
}
