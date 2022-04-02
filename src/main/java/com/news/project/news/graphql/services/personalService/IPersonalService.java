package com.news.project.news.graphql.services.personalService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Personal;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface IPersonalService {
    Optional<Personal> getPersonalById(Integer id);

    List<Personal> getPersonales();

    Personal addPersonal(Personal personal);

    Personal updatePersonal(Personal personal);

    Personal deletePersonal(Personal personal);
}
