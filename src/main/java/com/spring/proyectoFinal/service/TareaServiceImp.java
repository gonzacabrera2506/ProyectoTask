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
		Usuario usuarios = usuarioRepository.findById(idUsuario).get();
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		
		tarea.setEstado(estado);
		tarea.setComentarios(comentarios);
		tarea.setUsuario(usuarios);
		tarea.setProyecto(proyecto);
		
		tareaRepository.save(tarea);
		
		return tarea.getId();
		
	}

	@Override
	public TareaDTO buscarTareaPorId(Long id) {
		Tarea tarea = tareaRepository.findById(id).get();
		TareaDTO tareaDto = new TareaDTO(tarea);
		return tareaDto;
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

	@Override
	public Long agregarUsuarioATarea(Long idProyecto, Long idTarea, Long idUsuario) {
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		Tarea tarea = tareaRepository.findById(idTarea).get();
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		Long resultado = 0L;
		if(proyecto.getTareas().contains(tarea)) {
			tarea.setUsuario(usuario);
			tareaRepository.save(tarea);
			resultado = tarea.getUsuario().getId();
		}
		return resultado;
	}

	@Override
	public List<Tarea> mostrarTareas() {
		Iterable<Tarea> tareas = tareaRepository.findAll();
		List<Tarea> tareasRes = new ArrayList<Tarea>();
		for (Tarea tarea : tareas) {
			tareasRes.add(tarea);
		}
		return tareasRes;
	}
	
	
	

}
