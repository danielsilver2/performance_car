package br.univille.projetoperformance.controller;

import java.util.HashMap;
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
import br.univille.projetoperformance.model.Vehicle;
import br.univille.projetoperformance.repository.ClientRepository;
import br.univille.projetoperformance.repository.VehicleRepository;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("")
	public ModelAndView index() {
		List<Vehicle> vehicleList = this.vehicleRepository.findAll();
		
		for (Vehicle vehicle : vehicleList) {
			System.out.println(vehicle);
		}
		
		return new ModelAndView("vehicle/index", "vehicles", vehicleList);
	}
	
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute Vehicle vehicle) {
		
		List<Client> clientList = this.clientRepository.findAll();
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("vehicle", vehicle);
		data.put("clients", clientList);
		
		return new ModelAndView("vehicle/form", data);
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Vehicle vehicle, BindingResult result, RedirectAttributes redirect) {
	    
	    vehicle = this.vehicleRepository.save(vehicle);
	    
	    return new ModelAndView("redirect:/vehicles");
	}
	
	@GetMapping(value="update/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Vehicle vehicle) {
		
		Client client = vehicle.getClient();
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		List<Client> clientList = this.clientRepository.findAll();
		
		data.put("vehicle", vehicle);
		data.put("clients", clientList);

	    return new ModelAndView("vehicle/form", data);
	}
	
	@GetMapping(value="remove/{id}")
	public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
	    this.vehicleRepository.deleteById(id);
	    return new ModelAndView("redirect:/vehicles");
	}
}