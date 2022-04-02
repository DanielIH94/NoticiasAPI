package com.news.project.news.graphql.services.personalService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Personal;
import com.news.project.news.graphql.repositories.PersonalRepository;

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
public class PersonalService implements IPersonalService {

    @Autowired
    PersonalRepository personalRepository;

    @GraphQLQuery(name = "personal")
    public Optional<Personal> getPersonalById(@GraphQLArgument(name = "ID") Integer id) {
        return personalRepository.findById(id);
    }

    @GraphQLQuery(name = "personales")
    public List<Personal> getPersonales() {
        return personalRepository.findAll();
    }

    @GraphQLMutation(name = "addPersonal")
    public Personal addPersonal(@GraphQLArgument(name = "info") Personal personal) {
        return personalRepository.save(personal);
    }

    @GraphQLMutation(name = "updatePersonal")
    public Personal updatePersonal(@GraphQLArgument(name = "personal") Personal personal) {
        personalRepository.delete(personal);
        personalRepository.save(personal);

        return personal;
    }

    @GraphQLMutation(name = "deletePersonal")
    public Personal deletePersonal(@GraphQLArgument(name = "personal") Personal personal) {
        personalRepository.delete(personal);

        return personal;
    }

}
