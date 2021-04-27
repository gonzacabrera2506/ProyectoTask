package com.spring.proyectoFinal.bo;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String nombre;
	
	@ManyToMany(mappedBy = "usuario")
	private List<Tarea> tareas = new ArrayList<Tarea>();

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

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
	
}
