package com.hpv.CafeManha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hpv.CafeManha.model.ColaboradorModel;

public interface IColaboradorRepository extends JpaRepository<ColaboradorModel, Long>{
	
	
}
