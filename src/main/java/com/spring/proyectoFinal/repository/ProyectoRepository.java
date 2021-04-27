package com.spring.proyectoFinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.proyectoFinal.bo.Proyecto;


public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {

	@Query(value = "from Proyecto p")
	public List<Proyecto> buscarProductos();
	
	@Query(value = "from Proyecto p where p.nombre like :nombre")
	public List<Proyecto> buscarProductos(@Param("nombre") String nombre);
}
