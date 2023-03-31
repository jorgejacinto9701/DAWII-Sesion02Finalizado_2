package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	
	//Applicando query metodos
	public abstract List<Alumno> findByDni(String dni);
	public abstract List<Alumno> findByNombreLike(String nombre);
	
	//Aplicando JPQL (NO es SQL sino JPQL)
	@Query("select a from Alumno a where a.correo = ?1")
	public abstract List<Alumno> listaPorCorreo(String correo);

}
