package com.hpv.CafeManha;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import model.PratoColaboradorModel;

@SpringBootTest
class CafeManhaApplicationTests {

	@Test
	void contextLoads() {
		PratoColaboradorModel pratoColaboradorModel=new PratoColaboradorModel(1,"Joao","99999999999","Cafe",new Date(),true);
		
		assertEquals("Joao", pratoColaboradorModel.getNome());
	}

}
