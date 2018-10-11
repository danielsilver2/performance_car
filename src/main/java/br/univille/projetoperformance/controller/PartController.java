package br.univille.projetoperformance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.univille.projetoperformance.model.Part;
import br.univille.projetoperformance.repository.PartRepository;

@Controller
@RequestMapping("/parts")
public class PartController {
	PartRepository partRepository;
	
	@GetMapping("")
	public ModelAndView index() {
		
		List<Part> partList = this.partRepository.findAll();
		
		return new ModelAndView("part/index", "partList", partList);
	}
	
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute Part part) {
		
		return new ModelAndView("part/form", "part", part);
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Part part, BindingResult result, RedirectAttributes redirect) {
	    
	    part = this.partRepository.save(part);
	    
	    return new ModelAndView("redirect:/parts");
	}
	
	@GetMapping(value="update/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Part part) {
		
		
	    return new ModelAndView("part/form", "part", part);
	}
	
	@GetMapping(value="remove/{id}")
	public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
	    this.partRepository.deleteById(id);
	    return new ModelAndView("redirect:/parts");
	}
}