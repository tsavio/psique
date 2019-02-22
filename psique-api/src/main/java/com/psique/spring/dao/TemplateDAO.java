package com.psique.spring.dao;

import java.util.List;

import com.psique.spring.model.Patient;

/**
 * @author <a href="mailto:thyago@usto.re">Thyago Sávio</a>
 */

public interface TemplateDAO {

	// Salvar
	long savePatient(Patient patient);
	
	// Pegar um pelo id
	Patient getPatientById(long id);
	
	// Listar todos
	List<Patient> listAll();
	
	// Alterar algum 
	void updatePatientById(Long id, Patient patient);
	
	// Deletar 
	void deletePatientById(Long id);
	
}
