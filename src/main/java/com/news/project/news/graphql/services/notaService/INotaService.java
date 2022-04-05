package com.news.project.news.graphql.services.notaService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Nota;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface INotaService {
    Optional<Nota> getNotaById(Integer id);

    List<Nota> getNotas();

    Nota addNota(Nota nota, Integer idUsuario);

    Nota updateNota(Nota nota);

    Nota deleteNota(Nota nota);
}
