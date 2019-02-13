package com.psique.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psique.spring.model.Paciente;

/**
 * @author <a href="mailto:thyago@usto.re">Thyago Sávio</a>
 */

@Repository
public class PacienteDAO implements TemplateDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
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
	public List<Paciente> list() {
		List<Paciente> list = sessionFactory.getCurrentSession().createQuery("from Paciente").list();
		return list;
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
