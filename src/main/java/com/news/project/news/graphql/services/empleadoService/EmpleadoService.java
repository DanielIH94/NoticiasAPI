package com.news.project.news.graphql.services.empleadoService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Empleado;
import com.news.project.news.graphql.repositories.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

@Service
@GraphQLApi
public class EmpleadoService implements IEmpleadoService{

    @Autowired
    EmpleadoRepository empleadoRepository;

    @GraphQLQuery(name = "empleado")
    public Optional<Empleado> getEmpleadoById(@GraphQLArgument(name = "ID") Integer id) {
        return empleadoRepository.findById(id);
    }

    @GraphQLQuery(name = "empleados")
    public List<Empleado> getEmpleados() {
        return empleadoRepository.findAll();
    }

    @GraphQLMutation(name = "addEmpleado")
    public Empleado addEmpleado(@GraphQLArgument(name = "empleado") Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @GraphQLMutation(name = "updateEmpleado")
    public Empleado updateEmpleado(@GraphQLArgument(name = "empleado") Empleado empleado) {
        empleadoRepository.delete(empleado);
        empleadoRepository.save(empleado);
        
        return empleado;
    }

    @GraphQLMutation(name = "deleteEmpleado")
    public Empleado deleteEmpleado(@GraphQLArgument(name = "empleado") Empleado empleado) {
        empleadoRepository.delete(empleado);
        
        return empleado;
    }
    
}
