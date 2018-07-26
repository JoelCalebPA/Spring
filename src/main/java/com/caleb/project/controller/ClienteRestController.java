package com.caleb.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caleb.project.entity.Cliente;
import com.caleb.project.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

	private final ClienteRepository repository;

	@Autowired
	public ClienteRestController(ClienteRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Cliente> getClientes() {
		return repository.findAll();
	}
	
	@GetMapping("/{idCliente}")
	public Optional<Cliente> getCLiente(@PathVariable("idCliente") int idCliente) {
		return repository.findById(idCliente);
	}
	
}
