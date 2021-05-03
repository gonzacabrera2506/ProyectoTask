package com.spring.proyectoFinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.proyectoFinal.bo.Tarea;
//import com.spring.proyectoFinal.rest.TareaDTO;

public interface TareaRepository extends CrudRepository<Tarea, Long>{
	
	/*
	@Query(value = "from Tarea t where t.tipoTarea like :tipoTarea")
	public List<Tarea> buscarTareaPorNombre(@Param("tipoTarea") Long tipoTarea);
	*/
	@Query(value = "from Tarea t where t.usuario.id = :id")
	public List<Tarea> buscarTareasPorIdUsuario(@Param("id") Long id);
	
	@Query(value = "from Tarea t where t.proyecto.id = :id")
	public List<Tarea> mostrarTareasDelProyecto(@Param("id") Long id);
	
}
