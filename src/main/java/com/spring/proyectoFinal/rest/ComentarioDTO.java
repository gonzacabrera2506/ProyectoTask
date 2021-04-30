package com.spring.proyectoFinal.rest;

import java.time.LocalDate;
import java.util.Date;

import com.spring.proyectoFinal.bo.Comentario;

public class ComentarioDTO {

	private Long idComentario;
	private Long idTarea;
	private Long IdUsuario;
	private String nombreUsuario;
	private String descripcion;
	private LocalDate fecha;
	
	public ComentarioDTO(Comentario comentario) {
		this.idComentario = comentario.getId();
		if (comentario.getTarea()!=null) {
			this.idTarea = comentario.getTarea().getId();
		}
		if (comentario.getUsuario()!=null) {
			this.IdUsuario = comentario.getUsuario().getId();
			this.nombreUsuario = comentario.getUsuario().getNombre();
		}
		this.descripcion = comentario.getDescripcion();
		this.fecha = comentario.getFecha();
	}

	public ComentarioDTO() {
		
	}

	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}

	public Long getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		IdUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
