package com.spring.proyectoFinal.rest;


import com.spring.proyectoFinal.bo.Tarea;
import com.spring.proyectoFinal.bo.TipoTarea;

public class TareaDTO {
	
	private Long idTarea;
	private Long idEstado;
	private String estadoTarea;
	private Long idTipoTarea;
	private String tipoTarea;
	//usuarioDTO;
	
	public TareaDTO(Tarea tarea) {
	
		this.idTarea = tarea.getId();
		if (tarea.getEstado()!=null) {
			this.idEstado = tarea.getEstado().getId();
			this.estadoTarea = tarea.getEstado().getNombre();
		}
		if (tarea.getTipoTarea()!=null) {
			this.idTipoTarea = tarea.getTipoTarea().getId();
			this.tipoTarea = tarea.getTipoTarea().getNombre();
		}
	}

	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstadoTarea(Long idEstadoTarea) {
		this.idEstado = idEstadoTarea;
	}

	public String getEstadoTarea() {
		return estadoTarea;
	}

	public void setEstadoTarea(String estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	public Long getIdTipoTarea() {
		return idTipoTarea;
	}

	public void setIdTipoTarea(Long idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	public String getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}
	
}
