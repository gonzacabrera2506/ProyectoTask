package com.spring.proyectoFinal.service;

import java.util.List;

import com.spring.proyectoFinal.bo.Tarea;
import com.spring.proyectoFinal.rest.TareaDTO;

public interface TareaService {

	public Long altaTarea(Tarea Tarea, Long idEstado, Long idComentario, Long idUsuario, Long idProyecto);
	public TareaDTO buscarTareaPorId(Long id);
	public void borrarTarea(Long id);
	public void actualizarTarea(Tarea tarea);
	public List<Tarea> mostrarTareas();
	//public List<TareaDTO> mostrarTareasDelProyecto(Long idProyecto);
	public List<TareaDTO> mostrarTareasDelProyecto(Long idProyecto);
	public Long agregarUsuarioATarea(Long idProyecto, Long idTarea, Long idUsuario);
}

