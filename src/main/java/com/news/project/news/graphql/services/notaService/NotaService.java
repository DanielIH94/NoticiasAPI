package com.news.project.news.graphql.services.notaService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Nota;
import com.news.project.news.graphql.repositories.NotaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

@Service
@GraphQLApi
public class NotaService implements INotaService {

    @Autowired
    NotaRepository notaRepository;

    @GraphQLQuery(name = "nota")
    public Optional<Nota> getNotaById(Integer id) {
        return notaRepository.findById(id);
    }

    @GraphQLQuery(name = "notas")
    public List<Nota> getNotas() {
        return notaRepository.findAll();
    }

    @Override
    public Nota addNota(Nota nota) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Nota updateNota(Nota nota) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Nota deleteNota(Nota nota) {
        // TODO Auto-generated method stub
        return null;
    }

}
