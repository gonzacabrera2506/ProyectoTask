package com.spring.proyectoFinal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring.proyectoFinal.service.TareaService;

 @RestController
@RequestMapping("/tareas")
public class TareasRestController {
	 
	 @Autowired
		private TareaService tareaService;
	 
	 /*
	 @GetMapping(path = "/{id}")
		public ResponseEntity<TareaDTO> buscarProyectoPorId(@PathVariable Long id) {
			Proyecto proyecto = proyectoService.buscarProyectoPorId(id);
			ProyectoDTO proyectoDTO = new ProyectoDTO(proyecto);
			return ResponseEntity.ok(proyectoDTO);			
		}
		*/
}
