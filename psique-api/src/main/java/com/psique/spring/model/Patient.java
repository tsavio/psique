package com.psique.spring.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author <a href="mailto:thyago@usto.re">Thyago Sávio</a>
 */

@Entity(name = "Patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date dataNascimento;
	private String sexo;
	private String tipoSanguineo;
	private String cpf;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getdataNascimento() {
		return dataNascimento;
	}
	public void setdataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getsexo() {
		return sexo;
	}
	public void setsexo(String sexo) {
		this.sexo = sexo;
	}
	public String gettipoSanguineo() {
		return tipoSanguineo;
	}
	public void settipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}
	public String getcpf() {
		return cpf;
	}
	public void setcpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo +", tipoSanguineo=" + tipoSanguineo + ", cpf=" + cpf + "]";
	}
}
