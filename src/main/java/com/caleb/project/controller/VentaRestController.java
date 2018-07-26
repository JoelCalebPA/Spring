package com.caleb.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caleb.project.entity.Venta;
import com.caleb.project.repository.VentaRepository;

@RestController
@RequestMapping("/venta")
public class VentaRestController {

	private final VentaRepository repository;

	@Autowired
	public VentaRestController(VentaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/{idCliente}")
	public List<Venta> getVentasByCliente(@PathVariable("idCliente") int idCliente) {
		return repository.findAllByClienteIdCliente(idCliente);
	}
	
}
