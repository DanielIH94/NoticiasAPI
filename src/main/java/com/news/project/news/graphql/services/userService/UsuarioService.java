package com.news.project.news.graphql.services.userService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Personal;
import com.news.project.news.graphql.entities.Usuario;
import com.news.project.news.graphql.repositories.PersonalRepository;
import com.news.project.news.graphql.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graphql.GraphQLException;
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
public class UsuarioService implements IUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PersonalRepository personalRepository;

    @GraphQLQuery(name = "usuario")
    public Optional<Usuario> getUsuarioById(@GraphQLArgument(name = "ID") @GraphQLNonNull Integer id) {
        return usuarioRepository.findById(id);
    }

    @GraphQLQuery(name = "usuarioByNombreUsuario")
    public Optional<Usuario> getUsuarioById(@GraphQLNonNull String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    @GraphQLQuery(name = "usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @GraphQLQuery(name = "isInterno")
    public Boolean isInternal(@GraphQLArgument(name = "UserID") Integer idUser) {
        Usuario usuario = usuarioRepository.findById(idUser).get();
        if (usuario.getPersonal() == null)
            return false;

        return true;
    }

    @GraphQLQuery(name = "login")
    public Usuario login(String username, String password) {
        Usuario loggedUser = null;
        Optional<Usuario> optUsuario = usuarioRepository.findByNombreUsuario(username);
        if (optUsuario.isPresent()) {
            Usuario usuario = optUsuario.get();
            if (usuario.getContrasena().equals(password)) {
                loggedUser = usuario;
            }
        }

        return loggedUser;
    }

    @GraphQLMutation(name = "register")
    public Usuario addUsuario(@GraphQLNonNull Usuario usuario, Integer idPersonal) {
        Personal personal = null;
        if (idPersonal != null) {
            personal = personalRepository.getById(idPersonal);
            Optional<Personal> optPersonal = personalRepository.findById(idPersonal);
            optPersonal.ifPresent(_personal -> {
                if (usuarioRepository.existsByPersonal(_personal)) {
                    throw new GraphQLException("Ya hay una cuenta asosiada con este ID de personal");
                }
            });
        }

        if (usuarioRepository.existsByNombreUsuario(usuario.getNombreUsuario())) {
            throw new GraphQLException("El nombre de usuario ya existe");
        }

        usuario.setPersonal(personal);
        return usuarioRepository.save(usuario);
    }

    @GraphQLMutation(name = "updateUsuario")
    public Usuario updateUsuario(Usuario usuario) {
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
