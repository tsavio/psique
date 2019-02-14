package com.psique.spring.service;

import java.util.List;

import com.psique.spring.model.Paciente;

/**
 * @author <a href="mailto:thyago@usto.re">Thyago Sávio</a>
 */

public interface TemplateService {

		// Salvar
		long savePaciente(Paciente paciente);
		
		// Pegar um pelo id
		Paciente getPacienteById(long id);
		
		// Listar todos
		List<Paciente> listAll();
		
		// Alterar algum 
		void updatePacienteById(Long id, Paciente paciente);
		
		// Deletar 
		void deletePacienteById(Long id);
	
}
