package com.concesionario.app.web.rest;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import com.concesionario.app.service.TrabajadorDTOService;
import com.concesionario.app.service.dto.TrabajadorDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;


/**
 * REST controller for managing {@link com.concesionario.app.domain.TrabajadorDTO}.
 */
@RestController
@RequestMapping("/api")
public class TrabajadorDTOResource {

    private final Logger log = LoggerFactory.getLogger(TrabajadorDTOResource.class);

    private TrabajadorDTOService trabajadorDTOService;

    private static final String ENTITY_NAME = "trabajadorDTO";


    public TrabajadorDTOResource(TrabajadorDTOService trabajadorDTOService) {
        this.trabajadorDTOService = trabajadorDTOService;
    }


    /**
     * {@code GET  /trabajadorsDTO} : get all the trabajadorsDTO.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of trabajadors in body.
     */
    @GetMapping("/trabajadorsDTO")
    public ResponseEntity<List<TrabajadorDTO>> getAllTrabajadorsDTO(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to get a page of TrabajadorsDTO");
        Page<TrabajadorDTO> page = trabajadorDTOService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /trabajadors/:id} : get the "id" trabajadorDTO.
     *
     * @param id the id of the trabajadorDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the trabajador, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/trabajadorsDTO/{id}")
    public ResponseEntity<TrabajadorDTO> getTrabajadorDTO(@PathVariable Long id) {
        log.debug("REST request to get TrabajadorDTO : {}", id);
        Optional<TrabajadorDTO> trabajadorDTO = trabajadorDTOService.findOne(id);
        return ResponseUtil.wrapOrNotFound(trabajadorDTO);
    }
}
