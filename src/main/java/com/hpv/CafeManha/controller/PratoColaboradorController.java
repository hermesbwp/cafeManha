package com.hpv.CafeManha.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hpv.CafeManha.model.PratoColaboradorModel;
import com.hpv.CafeManha.service.PratoColaboradorService;

@RestController
public class PratoColaboradorController {
	
	@Autowired
	PratoColaboradorService pratoColaboradorService;
	
	@GetMapping("/teste")
	public String teste() {
		return "teste";
	}
	
	@GetMapping("/findAll")
	public List<PratoColaboradorModel> findAll() {
		return pratoColaboradorService.findAll();
	}
	
	@PostMapping("/add")
	public PratoColaboradorModel add(
			@RequestBody PratoColaboradorModel pratoColaborador) {
		return pratoColaboradorService.add(pratoColaborador);
	}

	@DeleteMapping("/delete{id}")
	public void delete(@PathVariable("id") Long id) {
		pratoColaboradorService.delete(id);
	}
	
	@PutMapping("/edit{id}")
	public PratoColaboradorModel edit(@PathVariable("id") Long id,@RequestBody PratoColaboradorModel pratoColaborador) {
		return pratoColaboradorService.edit(id,pratoColaborador);
	}
	
}
