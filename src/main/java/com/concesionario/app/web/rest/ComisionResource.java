package com.concesionario.app.web.rest;

import com.concesionario.app.domain.Comision;
import com.concesionario.app.service.ComisionService;
import com.concesionario.app.web.rest.errors.BadRequestAlertException;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.concesionario.app.domain.Comision}.
 */
@RestController
@RequestMapping("/api")
public class ComisionResource {

    private final Logger log = LoggerFactory.getLogger(ComisionResource.class);

    private static final String ENTITY_NAME = "comision";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ComisionService comisionService;

    public ComisionResource(ComisionService comisionService) {
        this.comisionService = comisionService;
    }

    /**
     * {@code POST  /comisions} : Create a new comision.
     *
     * @param comision the comision to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new comision, or with status {@code 400 (Bad Request)} if the comision has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/comisions")
    public ResponseEntity<Comision> createComision(@RequestBody Comision comision) throws URISyntaxException {
        log.debug("REST request to save Comision : {}", comision);
        if (comision.getId() != null) {
            throw new BadRequestAlertException("A new comision cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Comision result = comisionService.save(comision);
        return ResponseEntity.created(new URI("/api/comisions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /comisions} : Updates an existing comision.
     *
     * @param comision the comision to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated comision,
     * or with status {@code 400 (Bad Request)} if the comision is not valid,
     * or with status {@code 500 (Internal Server Error)} if the comision couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/comisions")
    public ResponseEntity<Comision> updateComision(@RequestBody Comision comision) throws URISyntaxException {
        log.debug("REST request to update Comision : {}", comision);
        if (comision.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Comision result = comisionService.save(comision);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, comision.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /comisions} : get all the comisions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of comisions in body.
     */
    @GetMapping("/comisions")
    public ResponseEntity<List<Comision>> getAllComisions(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to get a page of Comisions");
        Page<Comision> page = comisionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /comisions/:id} : get the "id" comision.
     *
     * @param id the id of the comision to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the comision, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/comisions/{id}")
    public ResponseEntity<Comision> getComision(@PathVariable Long id) {
        log.debug("REST request to get Comision : {}", id);
        Optional<Comision> comision = comisionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(comision);
    }

    /**
     * {@code DELETE  /comisions/:id} : delete the "id" comision.
     *
     * @param id the id of the comision to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/comisions/{id}")
    public ResponseEntity<Void> deleteComision(@PathVariable Long id) {
        log.debug("REST request to delete Comision : {}", id);
        comisionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
