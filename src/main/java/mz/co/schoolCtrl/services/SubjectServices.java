package mz.co.schoolCtrl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.co.schoolCtrl.model.Subject;
import mz.co.schoolCtrl.repository.SubjectRepository;

@Service
public class SubjectServices {

	@Autowired private SubjectRepository repositorio;

	public void save(Subject ingrediente){
		repositorio.save(ingrediente);
	}
	
	public Iterable<Subject> listar(){
		return repositorio.findAll();
	}
	
	public Subject findOne(Long id){
		return repositorio.findOne(id);
	}
	
	public void remove(Long id){
		Subject ingrediente = this.findOne(id);
		if(ingrediente!=null) repositorio.delete(ingrediente);
	}
	
}
