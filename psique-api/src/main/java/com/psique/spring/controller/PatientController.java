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

import com.psique.spring.model.Patient;
import com.psique.spring.service.PatientService;

/**
 * @author <a href="mailto:thyago@usto.re">Thyago Sávio</a>
 */

@CrossOrigin("*")
@RestController
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	//Listar todos os paciente
	@GetMapping("/api/patients")
	public ResponseEntity<List<Patient>>listAllPatient(){ 
		List<Patient> list = patientService.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Salvar Paciente
	@PostMapping("/api/patientCreate")
	public ResponseEntity<?> savePatient(@RequestBody Patient patient){
		long id = patientService.savePatient(patient);
		return ResponseEntity.ok().body("Paciente criado, id: "+ id);
	}
	
	//Pegar um paciente
	@GetMapping("/api/patient/{id}")
	public ResponseEntity<Patient> getPatientByid(@PathVariable("id") long id){
		Patient patient = patientService.getPatientById(id);
		return ResponseEntity.ok().body(patient);
	}
	
	//Editar Paciente
	@PutMapping("/api/patient/{id}")
	public ResponseEntity<?> updatePatientById(@PathVariable("id")long id, @RequestBody Patient patient){
		patientService.updatePatientById(id, patient);
		return ResponseEntity.ok().body("Paciente Atualizado com sucesso");
	}
	
	//Deletar Paciente
	@DeleteMapping("/api/patient/{id}")
	public ResponseEntity<?> deletePatientById (@PathVariable("id") long id){
		patientService.deletePatientById(id);
		return ResponseEntity.ok().body("Paciente deletado");
	}
}
