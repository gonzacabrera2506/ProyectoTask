package com.spring.proyectoFinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.proyectoFinal.bo.Comentario;
import com.spring.proyectoFinal.bo.Estado;
import com.spring.proyectoFinal.bo.Proyecto;
import com.spring.proyectoFinal.bo.Tarea;
import com.spring.proyectoFinal.bo.Usuario;
import com.spring.proyectoFinal.repository.ComentarioRepository;
import com.spring.proyectoFinal.repository.EstadoRepository;
import com.spring.proyectoFinal.repository.ProyectoRepository;
import com.spring.proyectoFinal.repository.TareaRepository;
import com.spring.proyectoFinal.repository.UsuarioRepository;
import com.spring.proyectoFinal.rest.TareaDTO;

@Service
public class TareaServiceImp implements TareaService{

	@Autowired
	private TareaRepository tareaRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Override
	public Long altaTarea(Tarea tarea, Long idEstado, Long idComentario, Long idUsuario, Long idProyecto) {
		
		Estado estado = estadoRepository.findById(idEstado).get();
		List<Comentario> comentarios = (List<Comentario>) comentarioRepository.findById(idComentario).get();
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findById(idUsuario).get();
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		
		tarea.setEstado(estado);
		tarea.setComentarios(comentarios);
		tarea.setUsuarios(usuarios);
		//tarea.setProyecto(proyecto);
		
		tareaRepository.save(tarea);
		
		return tarea.getId();
		
	}

	@Override
	public Tarea buscarTareaPorId(Long id) {
		return tareaRepository.findById(id).get();
	}

	@Override
	public void borrarTarea(Long id) {
		tareaRepository.deleteById(id);
	}

	@Override
	public void actualizarTarea(Tarea tarea) {
		tareaRepository.save(tarea);
	}

	@Override
	public List<TareaDTO> mostrarTareasDelProyecto(Long idProyecto) {
		List<TareaDTO> tareaDTO = new ArrayList<TareaDTO>();
		List<Tarea> tareas = tareaRepository.mostrarTareasDelProyecto(idProyecto);
		for (Tarea tarea : tareas) {
			tareaDTO.add(new TareaDTO(tarea));
		}
		return tareaDTO;
	}
	
	
	

}
