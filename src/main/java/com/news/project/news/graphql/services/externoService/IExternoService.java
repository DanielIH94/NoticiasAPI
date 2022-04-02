package com.news.project.news.graphql.services.externoService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Externo;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface IExternoService {
    Optional<Externo> getExternoById(Integer id);

    List<Externo> getExternos();

    Externo addExterno(Externo externo);

    Externo updateExterno(Externo externo);

    Externo deleteExterno(Externo externo);
}
