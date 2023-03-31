package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Alumno;

public interface AlumnoService {

	public abstract List<Alumno> listaAlumno();
	public abstract List<Alumno> listaAlumnoPorDni(String dni);
	public abstract List<Alumno> listaAlumnoPorNombreLike(String nombre);
	public abstract List<Alumno> listaAlumnoPorCorreo(String correo);
	public abstract Alumno insertaAlumno(Alumno obj);
	public abstract Alumno actualizaAlumno(Alumno obj);
	public abstract void eliminaAlumno(int idAlumno);
	public abstract Optional<Alumno> buscaAlumno(int idAlumno);
}
