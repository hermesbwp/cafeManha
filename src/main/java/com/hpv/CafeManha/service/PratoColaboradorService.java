package com.hpv.CafeManha.service;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hpv.CafeManha.model.PratoColaboradorModel;
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
		
		var dataAtual=new Date();
		
		if(!pratoColaborador.getDataCafe().after(dataAtual)) {
			pratoColaborador.setTrouxe(false);
		}
		
		//TODO procurar os pratos do dia
		var listOfPratosDia = pratoRepository.findPratoDia(pratoColaborador.getDataCafe());
		//TODO verificar se o novo prato pertence ao conjunto de pratos do dia
		
		
		if(colaboradorRepository.existsById(colaboradorId)&&pratoRepository.existsById(pratoId)) {
			pratoColaborador.setColaborador(colaboradorService.find(colaboradorId));
			pratoColaborador.setPrato(pratoService.find(pratoId));
			return pratoColaboradorRepository.save(pratoColaborador);
		}
		
		return null;
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

}
