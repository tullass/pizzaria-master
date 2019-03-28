package mz.co.schoolCtrl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mz.co.schoolCtrl.exception.IngredienteInvalidoException;
import mz.co.schoolCtrl.model.Subject;
import mz.co.schoolCtrl.services.SubjectServices;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired private SubjectServices serviceServices;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarSubjects(Model model){
		Iterable<Subject> subjects = serviceServices.listar();
		
		model.addAttribute("title", "Disciplina");
		model.addAttribute("subjects", subjects);
		return "academic/subject/main-subject";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarIngrediente(
			@Valid @ModelAttribute Subject servicee,
			BindingResult bindingResult,
			Model model){
		
		if ( bindingResult.hasErrors() ) {
			throw new IngredienteInvalidoException();
			
		} else {
			serviceServices.save(servicee);
			
		}

		model.addAttribute("subjects", serviceServices.listar());
		return "academic/subject/table-subject";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarSubject(@PathVariable Long id){
		try {
			serviceServices.remove(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}catch(Exception ex){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Subject buscarSubject(@PathVariable Long id){
		Subject ingrediente = serviceServices.findOne(id);
		return ingrediente;
	}
	
}
