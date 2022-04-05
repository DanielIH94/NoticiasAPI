package com.news.project.news.graphql.services.respuestaService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Respuesta;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface IRespuestaService {
    Optional<Respuesta> getRespuestaById(Integer id);

    List<Respuesta> getRespuestas();

    Respuesta addRespuesta(Respuesta respuesta, Integer idComentario, Integer idUsuario);

    Respuesta updateRespuesta(Respuesta respuesta);

    Respuesta deleteRespuesta(Respuesta respuesta);
}
