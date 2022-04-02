package com.news.project.news.graphql.services.externoService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Externo;
import com.news.project.news.graphql.repositories.ExternoRespository;

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
public class ExternoService implements IExternoService {

    @Autowired
    ExternoRespository externoRepository;

    @GraphQLQuery(name = "externo")
    public Optional<Externo> getExternoById(@GraphQLArgument(name = "ID") Integer id) {
        return externoRepository.findById(id);
    }

    @GraphQLQuery(name = "externos")
    public List<Externo> getExternos() {
        return externoRepository.findAll();
    }

    @GraphQLMutation(name = "addExterno")
    public Externo addExterno(@GraphQLArgument(name = "externo") Externo externo) {
        return externoRepository.save(externo);
    }

    @GraphQLMutation(name = "updateExterno")
    public Externo updateExterno(@GraphQLArgument(name = "externo") Externo externo) {
        externoRepository.delete(externo);
        externoRepository.save(externo);

        return externo;
    }

    @GraphQLMutation(name = "deleteExterno")
    public Externo deleteExterno(@GraphQLArgument(name = "externo") Externo externo) {
        externoRepository.delete(externo);

        return externo;
    }
}
