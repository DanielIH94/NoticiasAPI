package com.news.project.news.graphql.services.respuestaService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Respuesta;
import com.news.project.news.graphql.repositories.RespuestaRepository;

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
public class RespuestaService implements IRespuestaService {

    @Autowired
    RespuestaRepository respuestaRepository;

    @GraphQLQuery(name = "respuesta")
    public Optional<Respuesta> getRespuestaById(@GraphQLArgument(name = "ID") Integer id) {
        return respuestaRepository.findById(id);
    }

    @GraphQLQuery(name = "respuestas")
    public List<Respuesta> getRespuestas() {
        return respuestaRepository.findAll();
    }

    @GraphQLMutation(name = "addRespuesta")
    public Respuesta addRespuesta(@GraphQLArgument(name = "respuesta") Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    @GraphQLMutation(name = "updateRespuesta")
    public Respuesta updateRespuesta(@GraphQLArgument(name = "respuesta") Respuesta respuesta) {
        respuestaRepository.delete(respuesta);
        respuestaRepository.save(respuesta);

        return respuesta;
    }

    @GraphQLMutation(name = "deleteRespuesta")
    public Respuesta deleteRespuesta(@GraphQLArgument(name = "respuesta") Respuesta respuesta) {
        respuestaRepository.delete(respuesta);

        return respuesta;
    }

}
