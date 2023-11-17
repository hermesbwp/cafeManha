package com.hpv.CafeManha.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hpv.CafeManha.model.ColaboradorModel;
import com.hpv.CafeManha.repository.IColaboradorRepository;

@Service
public class ColaboradorService {
	@Autowired
	IColaboradorRepository colaboradorRepository;
	
	public List<ColaboradorModel> findAll() {
		return colaboradorRepository.findAll();
	}
	
	public ColaboradorModel find(Long id) {
		return colaboradorRepository.getReferenceById(id);
	}
	
	public ColaboradorModel add(ColaboradorModel colaborador) {
		
		var listOfColab = colaboradorRepository.findAll();
		
		for(ColaboradorModel c:listOfColab) {
			if(c.getCpf().equals(colaborador.getCpf())
					||c.getNome().equals(colaborador.getNome())) {
				return null;
			}
		}
		
		return colaboradorRepository.save(colaborador);
	}

	public void delete(Long id) {
		colaboradorRepository.deleteById(id);
	}

	public ColaboradorModel edit(Long id, ColaboradorModel colaboradorNovo) {
		
		if(colaboradorRepository.existsById(id)) {
			colaboradorNovo.setId(id);
			return colaboradorRepository.save(colaboradorNovo);
		}
		return null;
	}
	
}
