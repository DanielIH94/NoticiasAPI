package com.news.project.news.graphql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

@Entity
public class Externo {
    
    @Id
    @Column(name = "id_externo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExterno;

    @OneToOne
    @JoinColumn(name = "idUsuario", updatable = false, nullable = false)
    private Usuario usuario;

    public int getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(int idExterno) {
        this.idExterno = idExterno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
