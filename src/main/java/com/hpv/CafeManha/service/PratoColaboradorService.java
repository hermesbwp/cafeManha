package com.hpv.CafeManha.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hpv.CafeManha.model.PratoColaboradorModel;
import com.hpv.CafeManha.repository.IPratoColaboradorRepository;

@Service
public class PratoColaboradorService{

	@Autowired
	IPratoColaboradorRepository pratoColaboradorRepository;
	
	public List<PratoColaboradorModel> findAll() {
		return pratoColaboradorRepository.findAll();
	}
	
	public PratoColaboradorModel add(PratoColaboradorModel pratoColaborador) {
		return pratoColaboradorRepository.save(pratoColaborador);
	}

	public void delete(Long id) {
		pratoColaboradorRepository.deleteById(id);
	}

	public PratoColaboradorModel edit(Long id, PratoColaboradorModel pratoColaboradorNovo) {
		
		if(pratoColaboradorRepository.existsById(id)) {
			pratoColaboradorNovo.setId(id);
			return pratoColaboradorRepository.save(pratoColaboradorNovo);
		}
		return pratoColaboradorNovo;
	}

}
