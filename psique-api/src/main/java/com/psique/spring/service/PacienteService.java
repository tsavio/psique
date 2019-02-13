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
	public long save(Paciente paciente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Paciente get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Paciente> list() {
		return pacienteDAO.list();
	}

	@Override
	public void update(Long id, Paciente paciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
