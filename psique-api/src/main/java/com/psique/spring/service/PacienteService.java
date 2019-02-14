package com.psique.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psique.spring.dao.PacienteDAO;
import com.psique.spring.model.Paciente;

/**
 * @author <a href="mailto:thyago@usto.re">Thyago Sávio</a>
 */

@Service
public class PacienteService implements TemplateService{
	
	@Autowired
	private PacienteDAO pacienteDAO;

	@Override
	@Transactional
	public long savePaciente(Paciente paciente) {
		return pacienteDAO.savePaciente(paciente);
	}

	@Override
	@Transactional
	public Paciente getPacienteById(long id) {
		return pacienteDAO.getPacienteById(id);
	}

	@Override
	@Transactional
	public List<Paciente> listAll() {
		return pacienteDAO.listAll();
	}

	@Override
	@Transactional
	public void updatePacienteById(Long id, Paciente paciente) {
		pacienteDAO.updatePacienteById(id, paciente);
		
	}

	@Override
	@Transactional
	public void deletePacienteById(Long id) {
		pacienteDAO.deletePacienteById(id);
		
	}

}
