package com.news.project.news.graphql.repositories;

import java.util.Optional;

import com.news.project.news.graphql.entities.Personal;
import com.news.project.news.graphql.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 
 * @author Daniel Ibarra Hdez
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String username);

    boolean existsByNombreUsuario(String username);
    boolean existsByPersonal(Personal personal);
}
