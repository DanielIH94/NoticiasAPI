package com.news.project.news.graphql.services.respuestaService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Comentario;
import com.news.project.news.graphql.entities.Respuesta;
import com.news.project.news.graphql.entities.Usuario;
import com.news.project.news.graphql.repositories.ComentarioRepository;
import com.news.project.news.graphql.repositories.RespuestaRepository;
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
public class RespuestaService implements IRespuestaService {

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GraphQLQuery(name = "respuesta")
    public Optional<Respuesta> getRespuestaById(@GraphQLArgument(name = "ID") @GraphQLNonNull Integer id) {
        return respuestaRepository.findById(id);
    }

    @GraphQLQuery(name = "respuestas")
    public List<Respuesta> getRespuestas() {
        return respuestaRepository.findAll();
    }

    @GraphQLMutation(name = "addRespuesta")
    public Respuesta addRespuesta(
        @GraphQLNonNull Respuesta respuesta,
        @GraphQLNonNull Integer idComentario,
        @GraphQLNonNull Integer idUsuario
    ) {
        Optional<Comentario> optComentario = comentarioRepository.findById(idComentario);
        Optional<Usuario> optUsuario = usuarioRepository.findById(idUsuario);

        optComentario.ifPresent(comentario -> respuesta.setComentario(comentario));
        optUsuario.ifPresent(usuario -> respuesta.setUsuario(usuario));

        return respuestaRepository.save(respuesta);
    }

    @GraphQLMutation(name = "updateRespuesta")
    public Respuesta updateRespuesta(Respuesta respuesta) {
        respuestaRepository.delete(respuesta);
        respuestaRepository.save(respuesta);

        return respuesta;
    }

    @GraphQLMutation(name = "deleteRespuesta")
    public Respuesta deleteRespuesta(Respuesta respuesta) {
        respuestaRepository.delete(respuesta);

        return respuesta;
    }

}
