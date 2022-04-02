package com.news.project.news.graphql.repositories;

import com.news.project.news.graphql.entities.Respuesta;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {
    
}
