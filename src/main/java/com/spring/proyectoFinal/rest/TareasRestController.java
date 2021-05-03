package com.spring.proyectoFinal.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.proyectoFinal.bo.Tarea;
import com.spring.proyectoFinal.service.TareaService;

 @RestController
@RequestMapping("/tareas")
public class TareasRestController {
	 
	 @Autowired
		private TareaService tareaService;
	 
	 @GetMapping("/{id}")
		public ResponseEntity<TareaDTO> buscarTareaPorId(@PathVariable Long id){
			TareaDTO tarea = tareaService.buscarTareaPorId(id);
			return ResponseEntity.ok(tarea);
		}
	 
	 @GetMapping
		public ResponseEntity<List<TareaDTO>> mostrarTodasLasTareas(){
			List<Tarea> tareas = tareaService.mostrarTareas();
			List<TareaDTO> tareasRes = new ArrayList<TareaDTO>();
			for (Tarea tarea : tareas) {
				tareasRes.add(new TareaDTO(tarea));
			}
			return ResponseEntity.ok(tareasRes);
		}
	 
	 @DeleteMapping(path = "/{id}")
		public ResponseEntity borrarTarea(@PathVariable Long id) {
			tareaService.borrarTarea(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
}
