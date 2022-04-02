package com.news.project.news.graphql.repositories;

import com.news.project.news.graphql.entities.Externo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface ExternoRespository extends JpaRepository<Externo, Integer> {
}
