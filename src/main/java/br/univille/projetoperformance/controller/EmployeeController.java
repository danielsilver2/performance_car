package br.univille.projetoperformance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funcionario")
public class EmployeeController {
	@RequestMapping("")
	@ResponseBody
	public ModelAndView index() {
		
        return new ModelAndView("employee/index", "data", "paciente");		
	}
}