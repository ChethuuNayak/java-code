package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Visitor;
import com.example.demo.service.VisitorService;
import com.example.demo.service.impl.VisitorServiceImpl;

@Controller
public class VisitorController {
     
	private VisitorService visitorService;

	public VisitorController(VisitorService visitorService) {
		super();
		this.visitorService = visitorService;
	}
	
	
	@GetMapping("/visitors")
	public String page(Model model) {
		model.addAttribute("visitors",visitorService.show());
	return "indexMain";
	}
	
	@GetMapping("/visitors/new")
	public String button(Model model) {
		Visitor visitor=new Visitor();
		model.addAttribute("visitor",visitor);
		return "index";
	}
	
	
	@PostMapping("/visitors")
	public String add(@ModelAttribute("visitor") Visitor visitor) {
		visitorService.saveVisitor(visitor);
		return "redirect:/visitors";
	}
	
	@GetMapping("/visitors/edit/{id}")
	public String getById(@PathVariable int id,Model model) {
		model.addAttribute("visitor", visitorService.getById(id));
		return "edit";
	}
	
	@PostMapping("/visitors/{id}")
	public String saveUpdated(@PathVariable int id,@ModelAttribute("visitor") Visitor visitor) {
		Visitor existing=visitorService.getById(id);
		
		existing.setId(id);
		existing.setVisitorName(visitor.getVisitorName());
		existing.setCardNo(visitor.getCardNo());
		existing.setDate(visitor.getDate());
		existing.setAllowStatus(visitor.isAllowStatus());
		visitorService.saveVisitor(existing);
		
		return "redirect:/visitors";
	}
	
	@GetMapping("/visitors/delete/{id}")
	public String delete(@PathVariable Integer id) {
		visitorService.deleteById(id);
		return "redirect:/visitors";
		
	}
	
	
	
	
	
	
	
}
