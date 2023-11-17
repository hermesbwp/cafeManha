package com.hpv.CafeManha.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpv.CafeManha.model.PratoModel;

public interface IPratoRepository extends JpaRepository<PratoModel, Long>{
	
	@Query("select PratoModel from public.prato_model ")
	public List<PratoModel> findPratoDia(Date dia);
}
