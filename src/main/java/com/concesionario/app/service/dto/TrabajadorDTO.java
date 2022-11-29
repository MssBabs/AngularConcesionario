package com.concesionario.app.service.dto;

import com.concesionario.app.domain.Comision;
import com.concesionario.app.domain.Trabajador;


/**
 * A DTO representing a trabajador, with countSales and commissions.
 */
public class TrabajadorDTO {
    /* Trabajador Entity */
    private Long id;
    private String nombreCompleto;  /* == nombre + apellido */
    private String cargo;

    /* Otros */
    private Integer numeroVentas;   /* == count sobre las contraventas registradas al id de este usario */

    /* Comision Entity */
    private Long comision;       /* == comision.id asignado en funcion del numero de ventas */


    public TrabajadorDTO(Trabajador trabajador, Comision comision) {
        this.id = trabajador.getId();
        this.nombreCompleto = trabajador.getNombre() + " " + trabajador.getApellido();
        this.cargo = trabajador.getCargo();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public Integer getNumeroVentas() {
        return numeroVentas;
    }

    public void setNumeroVentas(Integer numeroVentas) {
        this.numeroVentas = numeroVentas;
    }


    public Long getComision() {
        return comision;
    }

    public void setComision(Long comision) {
        this.comision = comision;
    }
}
