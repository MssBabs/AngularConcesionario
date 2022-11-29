package com.concesionario.app.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Comision.
 */
@Entity
@Table(name = "comision")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Comision implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*New campo porciento*/
    @Column(name = "por_ciento")
    private Float porciento;

    /*New campo numeroVentas*/
    @Column(name = "numero_ventas")
    private Float numeroVentas;

    /*
     *  @OneToMany
     *  @JoinColumn(unique = true)
     *  private Trabajador trabajador;
     */


    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPorciento() {
        return porciento;
    }

    public void setPorciento(Float porciento) {
        this.porciento = porciento;
    }

    public Float getNumeroVentas() {
        return numeroVentas;
    }

    public void setNumeroVentas(Float numeroVentas) {
        this.numeroVentas = numeroVentas;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Comision)) {
            return false;
        }
        return id != null && id.equals(((Comision) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Comision{" +
            "id=" + getId() +
            "}";
    }
}
