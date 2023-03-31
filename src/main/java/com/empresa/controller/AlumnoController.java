package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

@RestController
@RequestMapping("/rest/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumno(){
		List<Alumno> lista = service.listaAlumno();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/porNombre/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumnoNombre(@PathVariable("filtro")String filtro){
		List<Alumno> lista = service.listaAlumnoPorNombreLike(filtro+"%");
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porDNI/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumnoDNI(@PathVariable("filtro")String filtro){
		List<Alumno> lista = service.listaAlumnoPorDni(filtro);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porCorreo/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumnoCorreo(@PathVariable("filtro")String filtro){
		List<Alumno> lista = service.listaAlumnoPorCorreo(filtro);
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> inserta(@RequestBody Alumno obj){
		HashMap<String, String> mensaje = new HashMap<>();
		Alumno objSalida = service.insertaAlumno(obj);
		if (objSalida == null) {
			mensaje.put("Mensaje", "No se registró");
		}else {
			mensaje.put("Mensaje", "Se registró el alumno con código " + obj.getIdAlumno());
		}
		return ResponseEntity.ok(mensaje);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> actualiza(@RequestBody Alumno obj){
		HashMap<String, String> mensaje = new HashMap<>();
		Alumno objSalida = service.actualizaAlumno(obj);
		if (objSalida == null) {
			mensaje.put("Mensaje", "No se actualizó");
		}else {
			mensaje.put("Mensaje", "Se actualizó el alumno con código " + obj.getIdAlumno());
		}
		return ResponseEntity.ok(mensaje);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> elimina(@PathVariable("id")int idAlumno){
		HashMap<String, String> mensaje = new HashMap<>();
		Optional<Alumno> optSalida = service.buscaAlumno(idAlumno);
		if (optSalida.isEmpty()) {
			mensaje.put("Mensaje", "No existe alumno con ID " + idAlumno);
		}else {
			service.eliminaAlumno(idAlumno);	
			Optional<Alumno> optEliminado = service.buscaAlumno(idAlumno);
			if( optEliminado.isEmpty()) {
				mensaje.put("Mensaje", "Se eliminó el alumno con código " + idAlumno);
			}
		}
		return ResponseEntity.ok(mensaje);
	}
	
}
