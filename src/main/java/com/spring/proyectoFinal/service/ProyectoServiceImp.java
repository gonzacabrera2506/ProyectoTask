package com.spring.proyectoFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.proyectoFinal.bo.Proyecto;
import com.spring.proyectoFinal.bo.Tarea;
import com.spring.proyectoFinal.bo.Usuario;
import com.spring.proyectoFinal.repository.ProyectoRepository;
import com.spring.proyectoFinal.repository.TareaRepository;
import com.spring.proyectoFinal.repository.UsuarioRepository;

@Service
public class ProyectoServiceImp implements ProyectoService {

	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Autowired
	private TareaRepository tareaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Proyecto>buscarProyectoPorNombre(String nombre) {
		return proyectoRepository.buscarProyectoPorNombre("%" + nombre + "%");
	}

	@Override
	public Proyecto buscarProyectoPorId(Long id) {
		return proyectoRepository.findById(id).get();
	}

	@Override
	public void borrarProyecto(Long id) {
		proyectoRepository.deleteById(id);
	}
	
	@Override
	public Long altaProyecto(Proyecto proyecto) {
		
		proyectoRepository.save(proyecto);
		
		return proyecto.getId();
	}

	@Override
	public Long mostrarTotalHorasAsignadas(Long idProyecto) {
		return proyectoRepository.findById(idProyecto).get().getTotalHorasAsignadas();
	}

	@Override
	public List<Tarea> mostrarTareasDelProyecto(Long idProyecto) {
		return proyectoRepository.findById(idProyecto).get().getTareas();
	}

}
