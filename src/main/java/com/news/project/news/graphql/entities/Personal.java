package com.news.project.news.graphql.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import io.leangen.graphql.annotations.GraphQLIgnore;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

@Entity
public class Personal {
    
    @Id
    @Column(name = "id_personal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonal;

    @Column(name = "ape_paterno")
    private String apellidoPaterno;

    @Column(name = "ape_materno")
    private String apellidoMaterno;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @OneToOne(mappedBy = "personal", cascade = CascadeType.REFRESH)
    private Usuario usuario;

    @GraphQLIgnore
    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdPersonal() {
        return idPersonal;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    @GraphQLIgnore
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    
}
