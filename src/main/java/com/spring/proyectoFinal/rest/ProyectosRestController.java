package com.spring.proyectoFinal.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.proyectoFinal.bo.Proyecto;
import com.spring.proyectoFinal.service.ProyectoService;
import com.spring.proyectoFinal.service.TareaService;

@RestController
@RequestMapping("/proyectos")
public class ProyectosRestController {

	 @Autowired
	private ProyectoService proyectoService;
	 
	 @Autowired
	 private TareaService tareaService;
	 
	 ////////////////////////////PROYECTOS////////////////////////////
	 
	@GetMapping(path = "/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<ProyectoDTO> buscarProyectoPorId(@PathVariable Long id) {
		Proyecto proyecto = proyectoService.buscarProyectoPorId(id);
		ProyectoDTO proyectoDTO = new ProyectoDTO(proyecto);
		return ResponseEntity.ok(proyectoDTO);			
	}
	
	@GetMapping(path = "/nombre")
	public ResponseEntity<ProyectoDTO> buscarProyectoPorNombre(@PathVariable String nombre) {
		Proyecto proyecto = (Proyecto) proyectoService.buscarProyectoPorNombre(nombre);
		ProyectoDTO proyectoDTO = new ProyectoDTO(proyecto);
		return ResponseEntity.ok(proyectoDTO);			
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity borrarProyecto(@PathVariable Long id) {
		proyectoService.borrarProyecto(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping(path = "/{id}/horas")
	public ResponseEntity<Long> mostrarTotalHorasAsignadas(@PathVariable Long id) {
		Long horas = proyectoService.mostrarTotalHorasAsignadas(id);

		return ResponseEntity.ok(horas);			
	}
	
	////////////////////////////TAREAS en PROYECTO////////////////////////////
	
	@GetMapping(path = "/{id}/tareas")
	public ResponseEntity<List<TareaDTO>> mostrarTareasDeProyecto(@PathVariable Long id) {
		List<TareaDTO> tareas = tareaService.mostrarTareasDelProyecto(id);
			return ResponseEntity.ok(tareas);		
	}
	
	@PutMapping(path="/{idProyecto}/tareas/{idTarea}")
	public ResponseEntity<Long> agregarUsuarioTarea(@PathVariable Long idProyecto, @PathVariable Long idTarea, 
			@RequestParam Long idUsuario){
		Long resultado = tareaService.agregarUsuarioATarea(idProyecto, idTarea, idUsuario);
		return ResponseEntity.ok(resultado);	
	}
	
	 
}
