package com.spring.proyectoFinal.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROYECTO")
public class Proyecto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String nombre;
	
	private Long totalHorasAsignadas;
	private Long horasDisponibles;
	
	@OneToMany
	@JoinColumn(name = "PROYECTO_ID")
	private List<Tarea> tareas = new ArrayList<Tarea>();
	
	@ManyToMany
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	@ManyToOne
	private Usuario usuarioResp = new Usuario();

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

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarioResp() {
		return usuarioResp;
	}

	public void setUsuarioResp(Usuario usuarioResp) {
		this.usuarioResp = usuarioResp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyecto other = (Proyecto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
}
