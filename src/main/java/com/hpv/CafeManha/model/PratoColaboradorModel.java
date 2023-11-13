package com.hpv.CafeManha.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class PratoColaboradorModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String prato;
	
	private Date dataCafe;
	
	private Boolean trouxe;
	
	public PratoColaboradorModel() {
		super();
	}

	public PratoColaboradorModel(Long id, String nome, String cpf, String prato, Date dataCafe, Boolean trouxe) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.prato = prato;
		this.dataCafe = dataCafe;
		this.trouxe = trouxe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPrato() {
		return prato;
	}

	public void setPrato(String prato) {
		this.prato = prato;
	}

	public Date getDataCafe() {
		return dataCafe;
	}

	public void setDataCafe(Date dataCafe) {
		this.dataCafe = dataCafe;
	}

	public Boolean getTrouxe() {
		return trouxe;
	}

	public void setTrouxe(Boolean trouxe) {
		this.trouxe = trouxe;
	}
	
}
