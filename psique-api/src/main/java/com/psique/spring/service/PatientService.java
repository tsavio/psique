package com.psique.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psique.spring.dao.PatientDAO;
import com.psique.spring.model.Patient;

/**
 * @author <a href="mailto:thyago@usto.re">Thyago Sávio</a>
 */

@Service
public class PatientService implements TemplateService{
	
	@Autowired
	private PatientDAO patientDAO;

	@Override
	@Transactional
	public long savePatient(Patient patient) {
		return patientDAO.savePatient(patient);
	}

	@Override
	@Transactional
	public Patient getPatientById(long id) {
		return patientDAO.getPatientById(id);
	}

	@Override
	@Transactional
	public List<Patient> listAll() {
		return patientDAO.listAll();
	}

	@Override
	@Transactional
	public void updatePatientById(Long id, Patient patient) {
		patientDAO.updatePatientById(id, patient);
		
	}

	@Override
	@Transactional
	public void deletePatientById(Long id) {
		patientDAO.deletePatientById(id);
		
	}

}
