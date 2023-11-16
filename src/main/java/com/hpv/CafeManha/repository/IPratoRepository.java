package com.hpv.CafeManha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hpv.CafeManha.model.PratoModel;

public interface IPratoRepository extends JpaRepository<PratoModel, Long>{
	
	
}
