package com.news.project.news.graphql.services.comentarioService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Comentario;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface IComentarioService {

    Optional<Comentario> getComentarioById(Integer id);

    List<Comentario> getComentarios();

    Comentario addComentario(Comentario comentario, Integer idNota, Integer idUsuario);

    Comentario updateComentario(Comentario comentario);

    Comentario deleteComentario(Comentario comentario);
}
