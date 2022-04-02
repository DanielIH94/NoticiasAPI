package com.news.project.news.graphql.repositories;

import com.news.project.news.graphql.entities.Nota;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface NotaRepository extends JpaRepository<Nota, Integer> {
}
