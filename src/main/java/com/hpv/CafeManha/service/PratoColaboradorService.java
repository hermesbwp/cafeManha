package com.hpv.CafeManha.service;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpv.CafeManha.model.ColaboradorModel;
import com.hpv.CafeManha.model.PratoColaboradorModel;
import com.hpv.CafeManha.model.PratoModel;
import com.hpv.CafeManha.repository.IColaboradorRepository;
import com.hpv.CafeManha.repository.IPratoColaboradorRepository;
import com.hpv.CafeManha.repository.IPratoRepository;

@Service
public class PratoColaboradorService{
	
	@Autowired
	ColaboradorService colaboradorService;
	
	@Autowired
	PratoService pratoService;

	@Autowired
	IPratoColaboradorRepository pratoColaboradorRepository;
	
	@Autowired
	IColaboradorRepository colaboradorRepository;
	
	@Autowired
	IPratoRepository pratoRepository;
	
	public List<PratoColaboradorModel> findAll() {
		return pratoColaboradorRepository.findAll();
	}
	
	public PratoColaboradorModel add(PratoColaboradorModel pratoColaborador, Long pratoId, Long colaboradorId) {
		var pratoNovo=new PratoModel();
		var colabNovo= new ColaboradorModel();
		
		if(pratoRepository.existsById(pratoId)&&colaboradorRepository.existsById(colaboradorId)) {
			pratoNovo=pratoService.find(pratoId);
			colabNovo=colaboradorService.find(colaboradorId);			
		}else {
			return null;
		}
		
		var dataAtual=new Date();
		
		if(!pratoColaborador.getDataCafe().after(dataAtual)) {
			pratoColaborador.setTrouxe(false);
		}
		
		if(!isColaboradorLevaMesmoPratoDia(pratoColaborador, pratoNovo, colabNovo)) {
			pratoColaborador.setColaborador(colabNovo);
			pratoColaborador.setPrato(pratoNovo);
			return pratoColaboradorRepository.save(pratoColaborador);
		}
		
		return null;
	}

	private boolean isColaboradorLevaMesmoPratoDia(PratoColaboradorModel pratoColaborador,
			PratoModel pratoNovo, ColaboradorModel colabNovo) {
		var listOfPratosColaboradorDia = pratoColaboradorRepository.findColaboradorPratoDia(pratoColaborador.getDataCafe());
		for(PratoColaboradorModel pratoColaboradorModel:listOfPratosColaboradorDia) {
			if(pratoColaboradorModel.getColaborador().equals(colabNovo)&&pratoColaboradorModel.getPrato().equals(pratoNovo)) {
			return false;
			}
		}return true;
	}

	public void delete(Long id) {
		pratoColaboradorRepository.deleteById(id);
	}

	public PratoColaboradorModel edit(Long id, PratoColaboradorModel pratoColaboradorNovo) {
		
		if(pratoColaboradorRepository.existsById(id)) {
			pratoColaboradorNovo.setId(id);
			return pratoColaboradorRepository.save(pratoColaboradorNovo);
		}
		return null;
	}
	
	public boolean isPratoLevadoEmpresa(Date dataCafe) {
		Date dataAtual = new Date();
		if(!(dataAtual.compareTo(dataCafe)==1)) {
			return false;			
		}
		return true;
	}
	
	public List<PratoColaboradorModel> teste(){
		return pratoColaboradorRepository.teste();
	}

}
