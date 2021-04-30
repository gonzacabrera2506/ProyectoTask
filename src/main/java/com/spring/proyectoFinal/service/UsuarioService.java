package com.spring.proyectoFinal.service;

import java.util.List;

import com.spring.proyectoFinal.bo.Comentario;
import com.spring.proyectoFinal.bo.Usuario;
import com.spring.proyectoFinal.rest.ComentarioDTO;
import com.spring.proyectoFinal.rest.TareaDTO;

public interface UsuarioService {
	
	public List<Usuario> mostrarUsuarios();
	public ComentarioDTO insertarComentario(Long idTarea, Long idUsuario, Comentario comentario);
	public Usuario buscarUsuarioPorId(Long idUsuario);
	public Long altaUsuario(Usuario usuario);
	public List<TareaDTO> mostrarTareasDelUsuario(Long idUsuario);
	 
}
