package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Visitor;

public interface VisitorService {
	
	Visitor saveVisitor(Visitor visitor);
	List<Visitor> show();
	
	Visitor getById(int id);
	
	Visitor saveUpdated(Visitor visitor);
	void deleteById(int id);

}
