package com.psique.spring.dao;

import java.util.List;

import org.hibernate.Session;
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
	public long savePaciente(Paciente paciente) {
		sessionFactory.getCurrentSession().save(paciente);
		return paciente.getId();
	}

	@Override
	public Paciente getPacienteById(long id) {
		return sessionFactory.getCurrentSession().get(Paciente.class, id);
	}

	@Override
	public List<Paciente> listAll() {
		List<Paciente> list = sessionFactory.getCurrentSession().createQuery("from Paciente").list();
		return list;
	}

	@Override
	public void updatePacienteById(Long id, Paciente paciente) {
		Session session = sessionFactory.getCurrentSession();
		Paciente pacienteAntigo = session.byId(Paciente.class).load(id);
		pacienteAntigo.setName(paciente.getName());
		session.flush();
	}

	@Override
	public void deletePacienteById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Paciente paciente = session.byId(Paciente.class).load(id);
		session.delete(paciente);
	}

}
