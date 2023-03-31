package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Alumno;
import com.empresa.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;

	@Override
	public List<Alumno> listaAlumno() {
		return repository.findAll();
	}

	@Override
	public List<Alumno> listaAlumnoPorDni(String dni) {
		return repository.findByDni(dni);
	}

	@Override
	public List<Alumno> listaAlumnoPorNombreLike(String nombre) {
		return repository.findByNombreLike(nombre);
	}

	@Override
	public List<Alumno> listaAlumnoPorCorreo(String correo) {
		return repository.listaPorCorreo(correo);
	}

	@Override
	public Alumno insertaAlumno(Alumno obj) {
		return repository.save(obj);
	}

	@Override
	public Alumno actualizaAlumno(Alumno obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaAlumno(int idAlumno) {
		repository.deleteById(idAlumno);
	}

	@Override
	public Optional<Alumno> buscaAlumno(int idAlumno) {
		return repository.findById(idAlumno);
	}


}
