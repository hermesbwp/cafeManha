package com.hpv.CafeManha;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hpv.CafeManha.model.ColaboradorModel;
import com.hpv.CafeManha.model.PratoColaboradorModel;
import com.hpv.CafeManha.model.PratoModel;
import com.hpv.CafeManha.repository.IPratoColaboradorRepository;

@SpringBootTest
class CafeManhaApplicationTests {

	@Test
	void contextLoads() {
		
		var colaborador= new ColaboradorModel((long) 1,"Jose","12345678909");
		var prato= new PratoModel((long) 1,"Cafe");
		PratoColaboradorModel pratoColaboradorModel=new PratoColaboradorModel((long) 1,colaborador,prato,new Date(),true);
		
		assertEquals("Jose", pratoColaboradorModel.getColaborador().getNome());
	}
	
	@Test
	void testeMesmoCOlaboradorLevandoMesmoPratoNoMesmoDia() {
		
		var colaborador= new ColaboradorModel((long) 1,"Jose","12345678909");
		var prato= new PratoModel((long) 1,"Cafe");
		PratoColaboradorModel pratoColaboradorModel=new PratoColaboradorModel((long) 1,colaborador,prato,new Date(),true);
		PratoColaboradorModel pratoColaboradorModelNovo=new PratoColaboradorModel((long) 2,colaborador,prato,new Date(),true);
		
		
		
		assertEquals("Jose", pratoColaboradorModel.getColaborador().getNome());
	}

}
