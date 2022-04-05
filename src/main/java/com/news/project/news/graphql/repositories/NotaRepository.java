package com.news.project.news.graphql.repositories;

import com.news.project.news.graphql.entities.Nota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {
}
