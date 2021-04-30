package com.spring.proyectoFinal.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.proyectoFinal.bo.Comentario;
import com.spring.proyectoFinal.bo.Usuario;
import com.spring.proyectoFinal.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuariosRestController {

	@Autowired
	private UsuarioService usuarioService;

	
	@GetMapping(path = "/{id}")
	public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(id);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return ResponseEntity.ok(usuarioDTO);			
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> mostrarUsuarios() {
		
		List<Usuario> usuarios = usuarioService.mostrarUsuarios();
		List<UsuarioDTO> usuarioDTO = new ArrayList<UsuarioDTO>();
		for(Usuario p : usuarios) {
			usuarioDTO.add(new UsuarioDTO(p));
		}
		return ResponseEntity.ok(usuarioDTO);
	}
	
	@GetMapping(path = "/{id}tareas")
	public ResponseEntity<List<TareaDTO>> verTareasUsuario(@PathVariable Long id){
		List<TareaDTO> tareas = usuarioService.mostrarTareasDelUsuario(id);
		return ResponseEntity.ok(tareas);
	}
	
	@PostMapping(path = "/{idUsuario}tareas{idTarea}/insertarcomentario")
	public ResponseEntity<ComentarioDTO> cargarComentarioTareaUsuario(@PathVariable Long idUsuario, 
			@PathVariable Long idTarea, @RequestBody Comentario comentario){
		ComentarioDTO comentarioInsertado = usuarioService.insertarComentario(idTarea, idUsuario, comentario);
		return ResponseEntity.status(HttpStatus.CREATED).body(comentarioInsertado);
	}
	
}
