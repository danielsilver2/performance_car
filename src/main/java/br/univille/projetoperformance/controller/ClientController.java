package br.univille.projetoperformance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.univille.projetoperformance.model.Client;
import br.univille.projetoperformance.repository.ClientRepository;

@Controller
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("")
	public ModelAndView index() {
		List<Client> clientList = this.clientRepository.findAll();
		
		return new ModelAndView("client/index", "clients", clientList);
	}
	
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute Client client) {
		return new ModelAndView("client/form", "client", client);
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Client client, BindingResult result, RedirectAttributes redirect) {
	    
	    client = this.clientRepository.save(client);
	    
	    return new ModelAndView("redirect:/clients");
	}
	
	@GetMapping(value="update/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Client client) {
	    return new ModelAndView("client/form", "client", client);
	}
	
	@GetMapping(value="remove/{id}")
	public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
	    this.clientRepository.deleteById(id);
	    return new ModelAndView("redirect:/clients");
	}
}
