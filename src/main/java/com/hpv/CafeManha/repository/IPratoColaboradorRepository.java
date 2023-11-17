package com.hpv.CafeManha.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hpv.CafeManha.model.PratoColaboradorModel;

public interface IPratoColaboradorRepository extends JpaRepository<PratoColaboradorModel, Long>{

	@Query(value="""
			select * from public.prato_colaborador_model 
			""",nativeQuery=true)
	public List<PratoColaboradorModel> teste();
	
	@Query(value="""
			select * from public.prato_colaborador_model 
			where data_cafe=?1
			""",nativeQuery=true)
	public List<PratoColaboradorModel> findColaboradorPratoDia(Date dataCafe);
	
	
}
