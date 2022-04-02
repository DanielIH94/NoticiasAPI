package com.news.project.news.graphql.repositories;

import com.news.project.news.graphql.entities.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}
