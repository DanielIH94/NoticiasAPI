package com.news.project.news.graphql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.leangen.graphql.annotations.GraphQLIgnore;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

@Entity
public class Empleado {
    
    @Id
    @Column(name = "id_empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;

    @OneToOne
    @JoinColumn(name = "idUsuario", updatable = false, nullable = false)
    private Usuario usuario;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @GraphQLIgnore
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
