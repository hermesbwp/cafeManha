package com.hpv.CafeManha.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpv.CafeManha.model.PratoModel;
import com.hpv.CafeManha.repository.IPratoRepository;

@Service
public class PratoService {
	@Autowired
	IPratoRepository pratoRepository;
	
	public List<PratoModel> findAll() {
		return pratoRepository.findAll();
	}
	
	public PratoModel add(PratoModel pratoColaborador) {
		
		return pratoRepository.save(pratoColaborador);
	}

	public void delete(Long id) {
		pratoRepository.deleteById(id);
	}

	public PratoModel edit(Long id, PratoModel prato) {
		
		if(pratoRepository.existsById(id)) {
			prato.setId(id);
			return pratoRepository.save(prato);
		}
		return null;
	}
	
}
