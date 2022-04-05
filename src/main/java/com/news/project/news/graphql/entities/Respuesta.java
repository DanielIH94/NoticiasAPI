package com.news.project.news.graphql.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.leangen.graphql.annotations.GraphQLIgnore;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

@Entity
public class Respuesta {
    @Id
    @Column(name = "id_respuesta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "fecha_res")
    private Date fechaRespuesta;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_comentario")
    private Comentario comentario;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Comentario getComentario() {
        return comentario;
    }

    @GraphQLIgnore
    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @GraphQLIgnore
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @GraphQLIgnore
    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }
}
