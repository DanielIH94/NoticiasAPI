package com.news.project.news.graphql.services.empleadoService;

import java.util.List;
import java.util.Optional;

import com.news.project.news.graphql.entities.Empleado;

/**
 * 
 * @author Daniel Ibarra Hdez
 */

public interface IEmpleadoService {
    Optional<Empleado> getEmpleadoById(Integer id);

    List<Empleado> getEmpleados();

    Empleado addEmpleado(Empleado empleado);

    Empleado updateEmpleado(Empleado empleado);

    Empleado deleteEmpleado(Empleado empleado);
}
