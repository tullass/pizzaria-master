package mz.co.schoolCtrl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.co.schoolCtrl.model.Teste;
import mz.co.schoolCtrl.repository.TesteRepository;

@Service
public class TesteServices {

	@Autowired 
	private TesteRepository repositorio;

	public void salvar(Teste teste){
		repositorio.save(teste);
	}
	
	public Iterable<Teste> listar(){
		return repositorio.findAll();
	}
	
	public Teste buscar(Long id){
		return repositorio.findOne(id);
	}
	
	public void remover(Long id){
		Teste teste = this.buscar(id);
		if(teste!=null) repositorio.delete(teste);
	}
	
}
