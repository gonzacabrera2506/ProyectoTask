package com.spring.proyectoFinal.rest;

import javax.validation.constraints.NotBlank;

import com.spring.proyectoFinal.bo.Proyecto;
import com.spring.proyectoFinal.bo.Tarea;
import com.spring.proyectoFinal.bo.Usuario;


public class ProyectoDTO {
	
	 private Long id;
	
	@NotBlank(message = "Falta completar el nombre del producto")
	private String nombre;
	private Long totalHorasAsignadas;
	private Long horasDisponibles;
	private Long idUsuarioResp;
	private String usuario;
	
	public ProyectoDTO() {}
	
	public ProyectoDTO(Proyecto proyecto) {
		this.id = proyecto.getId();
		this.nombre = proyecto.getNombre();
		this.totalHorasAsignadas =  proyecto.getTotalHorasAsignadas();
		this.horasDisponibles =  proyecto.getHorasDisponibles();
		Usuario usuarioResp = proyecto.getUsuarioResp();
		if(usuarioResp != null) {
			this.idUsuarioResp = usuarioResp.getId();
			this.usuario = usuarioResp.getNombre();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getTotalHorasAsignadas() {
		return totalHorasAsignadas;
	}

	public void setTotalHorasAsignadas(Long totalHorasAsignadas) {
		this.totalHorasAsignadas = totalHorasAsignadas;
	}

	public Long getHorasDisponibles() {
		return horasDisponibles;
	}

	public void setHorasDisponibles(Long horasDisponibles) {
		this.horasDisponibles = horasDisponibles;
	}

	public Long getIdUsuarioResp() {
		return idUsuarioResp;
	}

	public void setIdUsuarioResp(Long idUsuarioResp) {
		this.idUsuarioResp = idUsuarioResp;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
