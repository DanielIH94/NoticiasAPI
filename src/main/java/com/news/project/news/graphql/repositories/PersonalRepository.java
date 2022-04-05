package com.news.project.news.graphql.repositories;

import com.news.project.news.graphql.entities.Personal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {
}
