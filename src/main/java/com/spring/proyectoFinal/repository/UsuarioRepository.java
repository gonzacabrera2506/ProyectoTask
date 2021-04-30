package com.spring.proyectoFinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.proyectoFinal.bo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	@Query(value = "from Usuario u")
	public List<Usuario> mostrarUsuarios();
}
