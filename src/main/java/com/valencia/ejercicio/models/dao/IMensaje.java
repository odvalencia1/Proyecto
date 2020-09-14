package com.valencia.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.valencia.ejercicio.models.entities.Mensaje;

public interface IMensaje extends CrudRepository<Mensaje, Integer> {

}
