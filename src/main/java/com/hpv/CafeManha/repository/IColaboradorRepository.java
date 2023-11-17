package com.hpv.CafeManha.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hpv.CafeManha.model.ColaboradorModel;

public interface IColaboradorRepository extends JpaRepository<ColaboradorModel, Long>{
	public Optional<ColaboradorModel> findById(Long colaboradorId);
	
}
