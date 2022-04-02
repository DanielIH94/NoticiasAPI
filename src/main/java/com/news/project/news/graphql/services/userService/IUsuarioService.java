package com.news.project.news.graphql.services.userService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Usuario;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface IUsuarioService {
    Optional<Usuario> getUsuarioById(Integer id);

    List<Usuario> getUsuarios();

    Usuario addUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario);

    Usuario deleteUsuario(Usuario usuario);
}
