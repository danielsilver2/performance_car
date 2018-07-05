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

import br.univille.projetoperformance.model.User;
import br.univille.projetoperformance.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public ModelAndView getAll() {
		List<User> userList = this.userRepository.findAll();
		return new ModelAndView("user/index", "users", userList);
	}
	
	@GetMapping("/new")
	public String createUserForm(@ModelAttribute User user) {
		return "user/form";
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		user = this.userRepository.save(user);
		
		return new ModelAndView("redirect:/user/");
	}
	
	@GetMapping(value="/alterar/{id}")
	public ModelAndView updateForm(@PathVariable("id") User user) {
		return new ModelAndView("user/form", "user", user);
	}
	
	@GetMapping(value="/remover/{id}")
	public ModelAndView remove(@PathVariable ("id") Long id, RedirectAttributes redirect) {
		this.userRepository.deleteById(id);
		return new ModelAndView("redirect:/user/");
	}
	
	
}
