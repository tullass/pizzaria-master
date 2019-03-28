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
import mz.co.schoolCtrl.model.Servicee;
import mz.co.schoolCtrl.services.ServiceServices;

@Controller
@RequestMapping("/services")
public class ServiceeController {

	@Autowired private ServiceServices serviceServices;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarServicees(Model model){
		Iterable<Servicee> services = serviceServices.listar();
		
		model.addAttribute("titulo", "Servicos");
		model.addAttribute("services", services);
		return "academic/service/main-service";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarIngrediente(
			@Valid @ModelAttribute Servicee servicee,
			BindingResult bindingResult,
			Model model){
		
		if ( bindingResult.hasErrors() ) {
			throw new IngredienteInvalidoException();
			
		} else {
			serviceServices.salvar(servicee);
			
		}

		model.addAttribute("services", serviceServices.listar());
		return "academic/service/table-service";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarServicee(@PathVariable Long id){
		try {
			serviceServices.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}catch(Exception ex){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Servicee buscarServicee(@PathVariable Long id){
		Servicee ingrediente = serviceServices.buscar(id);
		return ingrediente;
	}
	
}
