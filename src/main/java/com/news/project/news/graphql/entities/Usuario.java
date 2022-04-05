package com.news.project.news.graphql.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import io.leangen.graphql.annotations.GraphQLIgnore;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

@Entity
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "contrasena")
    private String contrasena;

    @Lob
    @Column(name = "foto", length = 100000)
    private byte[] foto;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_personal", nullable = true)
    private Personal personal;

    @OneToMany(mappedBy = "usuario")
    private List<Nota> notas;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    private List<Respuesta> respuestas;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Personal getPersonal() {
        return personal;
    }

    @GraphQLIgnore
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    @GraphQLIgnore
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    @GraphQLIgnore
    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @GraphQLIgnore
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @GraphQLIgnore
    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "Usuario{" + nombreUsuario + "}";
    }
}
