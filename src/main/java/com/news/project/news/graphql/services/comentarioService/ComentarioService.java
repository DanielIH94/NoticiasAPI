package com.news.project.news.graphql.services.comentarioService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Comentario;
import com.news.project.news.graphql.repositories.ComentarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

@Service
@GraphQLApi
public class ComentarioService implements IComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    @GraphQLQuery(name = "comentario")
    public Optional<Comentario> getComentarioById(@GraphQLArgument(name = "ID") Integer id) {
        return comentarioRepository.findById(id);
    }

    @GraphQLQuery(name = "comentarios")
    public List<Comentario> getComentarios() {
        return comentarioRepository.findAll();
    }

    @GraphQLMutation(name = "addComentario")
    public Comentario addComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @GraphQLMutation(name = "updateComentario")
    public Comentario updateComentario(Comentario comentario) {
        comentarioRepository.delete(comentario);
        comentarioRepository.save(comentario);

        return comentario;
    }

    @GraphQLMutation(name = "deleteComentario")
    public Comentario deleteComentario(Comentario comentario) {
        comentarioRepository.delete(comentario);

        return comentario;
    }

}
