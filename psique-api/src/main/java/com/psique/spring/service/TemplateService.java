package com.psique.spring.service;

import java.util.List;

import com.psique.spring.model.Paciente;

/**
 * @author <a href="mailto:thyago@usto.re">Thyago Sávio</a>
 */

public interface TemplateService {

		// Salvar
		long save(Paciente paciente);
		
		// Pegar um pelo id
		Paciente get (long id);
		
		// Listar todos
		List<Paciente> list();
		
		// Alterar algum 
		void update (Long id, Paciente paciente);
		
		// Deletar 
		void delete(Long id);
	
}
