package com.news.project.news.graphql.services.comentarioService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Comentario;
import com.news.project.news.graphql.entities.Nota;
import com.news.project.news.graphql.entities.Usuario;
import com.news.project.news.graphql.repositories.ComentarioRepository;
import com.news.project.news.graphql.repositories.NotaRepository;
import com.news.project.news.graphql.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
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

    @Autowired
    NotaRepository notaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GraphQLQuery(name = "comentario")
    public Optional<Comentario> getComentarioById(@GraphQLArgument(name = "ID") @GraphQLNonNull Integer id) {
        return comentarioRepository.findById(id);
    }

    @GraphQLQuery(name = "comentarios")
    public List<Comentario> getComentarios() {
        return comentarioRepository.findAll();
    }

    @GraphQLMutation(name = "addComentario")
    public Comentario addComentario(
            @GraphQLNonNull Comentario comentario,
            @GraphQLNonNull Integer idNota,
            @GraphQLNonNull Integer idUsuario
    ) {
        Optional<Nota> optNota = notaRepository.findById(idNota);
        Optional<Usuario> optUsuario = usuarioRepository.findById(idUsuario);
        optNota.ifPresent(nota -> comentario.setNota(nota));
        optUsuario.ifPresent(usuario -> comentario.setUsuario(usuario));

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
