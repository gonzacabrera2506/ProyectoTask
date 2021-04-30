package com.spring.proyectoFinal.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.proyectoFinal.bo.Comentario;
import com.spring.proyectoFinal.bo.Tarea;
import com.spring.proyectoFinal.bo.Usuario;
import com.spring.proyectoFinal.repository.ComentarioRepository;
import com.spring.proyectoFinal.repository.TareaRepository;
import com.spring.proyectoFinal.repository.UsuarioRepository;
import com.spring.proyectoFinal.rest.ComentarioDTO;
import com.spring.proyectoFinal.rest.TareaDTO;

@Service
public class UsuarioServiceImp implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TareaRepository tareaRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;

	@Override
	public Long altaUsuario(Usuario usuario){
		usuarioRepository.save(usuario);
		return usuario.getId(); 	 
	}

	@Override
	public List<Usuario> mostrarUsuarios() {	
		return usuarioRepository.mostrarUsuarios();
	}

	@Override
	public Usuario buscarUsuarioPorId(Long idUsuario) {
		return usuarioRepository.findById(idUsuario).get();
	}

	@Override
	public List<TareaDTO> mostrarTareasDelUsuario(Long idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		List<Tarea> tareas = usuario.getTareas();
		List<TareaDTO> tareasDto = new ArrayList<TareaDTO>(); 
		for (Tarea tarea : tareas) {
			tareasDto.add(new TareaDTO(tarea));
		}
		return tareasDto;
	}

	@Override
	public ComentarioDTO insertarComentario(Long idTarea, Long idUsuario, Comentario comentario) {
		Comentario comentarioAgregado = new Comentario();
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		Tarea tarea = tareaRepository.findById(idTarea).get();
		
		comentarioAgregado.setDescripcion(comentario.getDescripcion());
		comentarioAgregado.setTarea(tarea);
		comentarioAgregado.setUsuario(usuario);
		comentarioAgregado.setFecha(LocalDate.now());
		
		
		ComentarioDTO coment = new ComentarioDTO(comentarioAgregado);
		comentarioRepository.save(comentarioAgregado);
		return coment;
	}

}
