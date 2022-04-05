package com.news.project.news.graphql.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import io.leangen.graphql.annotations.GraphQLIgnore;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

@Entity
public class Comentario {

    @Id
    @Column(name = "id_comentario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "fecha_com")
    private Date fechaComentario;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nota")
    private Nota nota;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "comentario")
    private List<Respuesta> respuestas;

    public int getIdComentario() {
        return idComentario;
    }

    @GraphQLIgnore
    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }



    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public Nota getNota() {
        return nota;
    }

    @GraphQLIgnore
    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @GraphQLIgnore
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    @GraphQLIgnore
    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
