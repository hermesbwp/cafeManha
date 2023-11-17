package com.hpv.CafeManha.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hpv.CafeManha.model.ColaboradorModel;
import com.hpv.CafeManha.model.PratoColaboradorModel;
import com.hpv.CafeManha.model.PratoModel;
import com.hpv.CafeManha.service.ColaboradorService;
import com.hpv.CafeManha.service.PratoColaboradorService;
import com.hpv.CafeManha.service.PratoService;

@RestController
public class Fachada {
	
	@Autowired
	PratoColaboradorService pratoColaboradorService;
	
	@Autowired
	ColaboradorService colaboradorService;
	
	@Autowired
	PratoService pratoService;
	
	@GetMapping("/teste")
	public ResponseEntity<String> teste() {
		return new ResponseEntity<String>("Teste", HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public List<PratoColaboradorModel> findAll() {
		return pratoColaboradorService.findAll();
	}
	
	@GetMapping("/findAllColaborador")
	public List<ColaboradorModel> findAllColaborador() {
		return colaboradorService.findAll();
	}
	
	@GetMapping("/findAllPrato")
	public List<PratoModel> findAllPrato() {
		return pratoService.findAll();
	}
	
	@PostMapping("/addPratoColaborador/{idPrato}/{idColaborador}")
	public void add(
			@RequestBody PratoColaboradorModel pratoColaborador,
			@PathVariable("idPrato") Long idPrato,
			@PathVariable("idColaborador") Long idColaborador) {
		pratoColaboradorService.add(pratoColaborador,idPrato,idColaborador);
	}
	
	@PostMapping("/addColaborador")
	public ColaboradorModel add(
			@RequestBody ColaboradorModel colaborador) {
		return colaboradorService.add(colaborador);
	}
	
	@PostMapping("/addPrato")
	public PratoModel add(
			@RequestBody PratoModel prato) {
		return pratoService.add(prato);
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
