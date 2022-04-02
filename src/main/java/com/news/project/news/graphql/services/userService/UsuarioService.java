package com.news.project.news.graphql.services.userService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Usuario;
import com.news.project.news.graphql.repositories.UsuarioRepository;

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
public class UsuarioService implements IUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GraphQLQuery(name = "usuario")
    public Optional<Usuario> getUsuarioById(@GraphQLArgument(name = "ID") Integer id) {
        return usuarioRepository.findById(id);
    }

    @GraphQLQuery(name = "usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @GraphQLMutation(name = "addUsuario")
    public Usuario addUsuario(@GraphQLArgument(name = "usuario") Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GraphQLMutation(name = "updateUsuario")
    public Usuario updateUsuario(@GraphQLArgument(name = "usuario") Usuario usuario) {
        usuarioRepository.delete(usuario);
        usuarioRepository.save(usuario);

        return usuario;
    }

    @GraphQLMutation(name = "deleteUsuario")
    public Usuario deleteUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
        return usuario;
    }

}
