package mz.co.schoolCtrl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.co.schoolCtrl.model.Servicee;
import mz.co.schoolCtrl.repository.ServiceRepository;

@Service
public class ServiceServices {

	@Autowired private ServiceRepository repositorio;

	public void salvar(Servicee ingrediente){
		repositorio.save(ingrediente);
	}
	
	public Iterable<Servicee> listar(){
		return repositorio.findAll();
	}
	
	public Servicee buscar(Long id){
		return repositorio.findOne(id);
	}
	
	public void remover(Long id){
		Servicee ingrediente = this.buscar(id);
		if(ingrediente!=null) repositorio.delete(ingrediente);
	}
	
}
