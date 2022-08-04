package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;

@Service
public class VisitorServiceImpl implements VisitorService{

	private VisitorRepository visitorRepository;
	
	public VisitorServiceImpl(VisitorRepository visitorRepository) {
		super();
		this.visitorRepository = visitorRepository;
	}

	@Override
	public Visitor saveVisitor(Visitor visitor) {
		return visitorRepository.save(visitor);
	}

	@Override
	public List<Visitor> show() {
		return visitorRepository.findAll();
	}

	@Override
	public Visitor getById(int id) {
	   return visitorRepository.findById(id).get();
	}

	@Override
	public Visitor saveUpdated(Visitor visitor) {
		return visitorRepository.save(visitor);
	}

	@Override
	public void deleteById(int id) {
		visitorRepository.deleteById(id);
		
	}
  

  
}
