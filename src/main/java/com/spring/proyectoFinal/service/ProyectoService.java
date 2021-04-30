package com.spring.proyectoFinal.service;

import java.util.List;

import com.spring.proyectoFinal.bo.Proyecto;
import com.spring.proyectoFinal.bo.Tarea;
import com.spring.proyectoFinal.rest.ProyectoDTO;


public interface ProyectoService {
	public Proyecto buscarProyectoPorId(Long id);
	public List<Proyecto> buscarProyectoPorNombre(String nombre);
	public Long altaProyecto(Proyecto proyecto);
	public void borrarProyecto(Long id);
	public Long mostrarTotalHorasAsignadas(Long idProyecto);
	public List<Tarea> mostrarTareasDelProyecto(Long idProyecto);
	
}
