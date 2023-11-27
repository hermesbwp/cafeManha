package com.hpv.CafeManha;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hpv.CafeManha.model.ColaboradorModel;
import com.hpv.CafeManha.model.PratoColaboradorModel;
import com.hpv.CafeManha.model.PratoModel;
import com.hpv.CafeManha.service.ColaboradorService;
import com.hpv.CafeManha.service.PratoColaboradorService;
import com.hpv.CafeManha.service.PratoService;

@SpringBootTest
class CafeManhaApplicationTests {
	
	@Autowired
	ColaboradorService colaboradorService;
	
	@Autowired
	PratoService pratoService;
	
	@Autowired
	PratoColaboradorService pratoColaboradorService;

	@Test
	void contextLoads() {
		
		var colaborador= new ColaboradorModel((long) 1,"Jose","12345678909");
		var prato= new PratoModel((long) 1,"Cafe");
		PratoColaboradorModel pratoColaboradorModel=new PratoColaboradorModel((long) 1,colaborador,prato,new Date(),true);
		
		assertEquals("Jose", pratoColaboradorModel.getColaborador().getNome());
	}
	
	@Test
	void testeMesmoColaboradorLevandoMesmoPratoNoMesmoDia() {
		
		var colaborador= new ColaboradorModel((long) 1,"Jose","12345678909");
		colaboradorService.add(colaborador);		
		var prato= new PratoModel((long) 1,"Cafe");
		pratoService.add(prato);
		Date agora = new Date();
		PratoColaboradorModel pratoColaboradorModel = new PratoColaboradorModel((long) 1,colaborador,prato,agora,null);
		
		pratoColaboradorService.add(pratoColaboradorModel,(long)1,(long)1);
		assertEquals(null, pratoColaboradorService.add(pratoColaboradorModel,(long)1,(long)1));
	}
	
	@Test
	void testeMesmoColaborador() {
		
		var colaborador= new ColaboradorModel((long) 1,"Jose","12345678909");
		colaboradorService.add(colaborador);
		assertEquals(null, colaboradorService.add(colaborador));
	}
	
	@Test
	void testeMesmoPrato() {
		
		var prato= new PratoModel((long) 1,"Pao");
		pratoService.add(prato);
		assertEquals(null, pratoService.add(prato));
	}

}
