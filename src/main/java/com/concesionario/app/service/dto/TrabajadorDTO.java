package com.concesionario.app.service.dto;


/**
 * A DTO representing a trabajador, with countSales and commissions.
 */
public class TrabajadorDTO {
    /* Trabajador Entity */
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private String cargo;
    private Integer telefono;

    /* Otros */
    private Integer numeroVentas;   /* == count sobre las contraventas registradas al id de este usario */

    /* Comision Entity */
    private Float comision;       /* == comision.id asignado en funcion del numero de ventas */


    public TrabajadorDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }


    public Integer getNumeroVentas() {
        return numeroVentas;
    }

    public void setNumeroVentas(Integer numeroVentas) {
        this.numeroVentas = numeroVentas;
    }


    public Float getComision() {
        return comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }
}
