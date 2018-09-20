package br.univille.projetoperformance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetoperformance.model.UserModel;
import br.univille.projetoperformance.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	public ModelAndView index() {
        List<UserModel> userList = this.userRepository.findAll();
        
//        userList.add(p1);
        
        return new ModelAndView("paciente/index","listapac", userList);		
	}
}
