package com.news.project.news.graphql.repositories;

import com.news.project.news.graphql.entities.Personal;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface PersonalRepository extends JpaRepository<Personal, Integer> {
    
}
