package com.hpv.CafeManha.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class PratoColaboradorModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="id_colaborador", nullable=false, updatable=false)
	private ColaboradorModel colaborador;
	
	@OneToOne
	@JoinColumn(name="id_prato", nullable=false, updatable=false)
	private PratoModel prato;
	
	private Date dataCafe;
	
	private Boolean trouxe;
	
	public PratoColaboradorModel() {
		super();
	}

	public PratoColaboradorModel(Long id, ColaboradorModel colaborador, PratoModel prato, Date dataCafe,
			Boolean trouxe) {
		super();
		this.id = id;
		this.colaborador = colaborador;
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

	public ColaboradorModel getColaborador() {
		return colaborador;
	}

	public void setColaborador(ColaboradorModel colaborador) {
		this.colaborador = colaborador;
	}

	public PratoModel getPrato() {
		return prato;
	}

	public void setPrato(PratoModel prato) {
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
