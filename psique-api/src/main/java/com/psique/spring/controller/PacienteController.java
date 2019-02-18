package com.psique.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psique.spring.model.Paciente;
import com.psique.spring.service.PacienteService;

@CrossOrigin("*")
@RestController
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	//Listar todos os paciente
	@GetMapping("/api/pacientes")
	public ResponseEntity<List<Paciente>>listAllPaciente(){ 
		List<Paciente> list = pacienteService.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Salvar Paciente
	@PostMapping("/api/pacienteCreate")
	public ResponseEntity<?> savePaciente(@RequestBody Paciente paciente){
		long id = pacienteService.savePaciente(paciente);
		return ResponseEntity.ok().body("Paciente criado, id: "+ id);
	}
	
	//Pegar um paciente
	@GetMapping("/api/paciente/{id}")
	public ResponseEntity<Paciente> getPacienteByid(@PathVariable("id") long id){
		Paciente paciente = pacienteService.getPacienteById(id);
		return ResponseEntity.ok().body(paciente);
		
	}
	
	//Editar Paciente
	@PutMapping("/api/paciente/{id}")
	public ResponseEntity<?> updatePacienteById(@PathVariable("id")long id, @RequestBody Paciente paciente){
		pacienteService.updatePacienteById(id, paciente);
		return ResponseEntity.ok().body("Paciente Atualizado com sucesso");
	}
	
	//Deletar Paciente
	@DeleteMapping("/api/paciente/{id}")
	public ResponseEntity<?> deletePacienteById (@PathVariable("id") long id){
		pacienteService.deletePacienteById(id);
		return ResponseEntity.ok().body("Paciente deletado");
	}
}
