package mz.co.schoolCtrl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mz.co.schoolCtrl.exception.IngredienteInvalidoException;
import mz.co.schoolCtrl.model.Teste;
import mz.co.schoolCtrl.services.TesteServices;

@Controller
@RequestMapping("/teste")
public class TesteController {

	@Autowired private TesteServices testeServices;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarTestes(Model model){
		//Iterable<Teste> subjects = testeServices.listar();
		
		model.addAttribute("title", "Teste");
		model.addAttribute("listaTestes", testeServices.listar());
		return "academic/teste/main-teste";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarIngrediente(
			@Valid @ModelAttribute Teste teste,
			BindingResult bindingResult,
			Model model){
		
		if ( bindingResult.hasErrors() ) {
			throw new IngredienteInvalidoException();
			
		} else {
			testeServices.salvar(teste);
			
			
		}

		model.addAttribute("listaTestes", testeServices.listar());
		return "academic/teste/table-teste";
	}
	
//	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
//	public ResponseEntity<String> deletarTeste(@PathVariable Long id){
//		try {
//			testeServices.remove(id);
//			return new ResponseEntity<String>(HttpStatus.OK);
//			
//		}catch(Exception ex){
//			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//			
//		}
//	}
//	
//	@RequestMapping(method=RequestMethod.GET, value="/{id}")
//	@ResponseBody
//	public Teste buscarTeste(@PathVariable Long id){
//		Teste ingrediente = testeServices.findOne(id);
//		return ingrediente;
//	}
	
}
