package com.news.project.news.graphql.repositories;

import com.news.project.news.graphql.entities.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
