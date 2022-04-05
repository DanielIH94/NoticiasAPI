package com.news.project.news.graphql.services.notaService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Nota;
import com.news.project.news.graphql.entities.Usuario;
import com.news.project.news.graphql.repositories.NotaRepository;
import com.news.project.news.graphql.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
public class NotaService implements INotaService {

    @Autowired
    NotaRepository notaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GraphQLQuery(name = "nota")
    public Optional<Nota> getNotaById(@GraphQLArgument(name = "ID") @GraphQLNonNull Integer id) {
        return notaRepository.findById(id);
    }

    @GraphQLQuery(name = "notas")
    public List<Nota> getNotas() {
        return notaRepository.findAll(Sort.by(Sort.Direction.DESC, "fechaNota"));
    }

    @GraphQLMutation(name = "addNota")
    public Nota addNota(@GraphQLNonNull Nota nota, Integer idUsuario) {
        Optional<Usuario> optUsaurio = usuarioRepository.findById(idUsuario);
        optUsaurio.ifPresent(usuario -> nota.setUsuario(usuario));

        return notaRepository.save(nota);
    }

    @GraphQLMutation(name = "updateNota")
    public Nota updateNota(Nota nota) {
        notaRepository.delete(nota);
        notaRepository.save(nota);
        return nota;
    }

    @GraphQLMutation(name = "deleteNota")
    public Nota deleteNota(Nota nota) {
        notaRepository.delete(nota);
        return nota;
    }

}
