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

    Usuario addUsuario(Usuario usuario, Integer idPersonal);

    Usuario updateUsuario(Usuario usuario);

    Usuario deleteUsuario(Usuario usuario);

    Boolean isInternal(Integer id);

    Usuario login(String username, String password);
}
