package com.news.project.news.graphql.repositories;

import com.news.project.news.graphql.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
