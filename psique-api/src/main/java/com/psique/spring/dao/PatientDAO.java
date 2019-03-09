package com.psique.spring.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psique.spring.model.Patient;

/**
 * @author <a href="mailto:thyago@usto.re">Thyago Sávio</a>
 */

@Repository
public class PatientDAO implements TemplateDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long savePatient(Patient patient) {
		sessionFactory.getCurrentSession().save(patient);
		return patient.getId();
	}

	@Override
	public Patient getPatientById(long id) {
		return sessionFactory.getCurrentSession().get(Patient.class, id);
	}

	@Override
	public List<Patient> listAll() throws ClassCastException {
		//TODO usa essa anotação pois o Warnings é inerente ao hibernate, por não saber o tipo da lista em runtime.
		@SuppressWarnings("unchecked") 
		List<Patient> list = Collections.checkedList(sessionFactory.getCurrentSession().createQuery("from Patient").list(), Patient.class);
		
		return list;
	}

	@Override
	public void updatePatientById(Long id, Patient patient) {
		Session session = sessionFactory.getCurrentSession();
		Patient pacienteAntigo = session.byId(Patient.class).load(id);
		pacienteAntigo.setName(patient.getName());
		pacienteAntigo.setdataNascimento(patient.getdataNascimento());
		pacienteAntigo.setsexo(patient.getsexo());
		pacienteAntigo.settipoSanguineo(patient.gettipoSanguineo());
		pacienteAntigo.setcpf(patient.getcpf());
		session.flush();
	}

	@Override
	public void deletePatientById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Patient patient = session.byId(Patient.class).load(id);
		session.delete(patient);
	}

}
