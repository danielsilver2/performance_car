package br.univille.projetoperformance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.univille.projetoperformance.model.Paciente;
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
        
        return new ModelAndView("user/index","listapac", userList);		
	}

    @GetMapping("/new")
    public String createForm(@ModelAttribute UserModel user) {
        return "user/form";
    }
    
    @PostMapping(params="form")
    public ModelAndView save(@Valid UserModel user, BindingResult result, RedirectAttributes redirect) {
        
        user = this.userRepository.save(user);
        
        return new ModelAndView("redirect:/user");
    }
    
    @GetMapping(value="update/{id}")
    public ModelAndView alterarForm(@PathVariable("id") UserModel user) {
        return new ModelAndView("user/form","user",user);
    }
    
    @GetMapping(value="remove/{id}")
    public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
        this.userRepository.deleteById(id);
        return new ModelAndView("redirect:/user");
    }
}
