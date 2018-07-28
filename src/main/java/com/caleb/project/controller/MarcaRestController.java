package com.caleb.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caleb.project.entity.Marca;
import com.caleb.project.repository.MarcaRepository;

@RestController
@RequestMapping("/api/marca")
public class MarcaRestController {

	private final MarcaRepository repository;

	@Autowired
	public MarcaRestController(MarcaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Marca> getMarcas() {
		return repository.findAll();
	}
	
	@PostMapping
	public void saveMarca(@RequestBody Marca marca) {
		repository.save(marca);
	}
	
}
