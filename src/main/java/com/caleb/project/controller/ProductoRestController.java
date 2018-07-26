/**
 * 
 */
package com.caleb.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caleb.project.entity.Producto;
import com.caleb.project.repository.ProductoRepository;

/**
 * @author caleb
 *
 */

@RestController
@RequestMapping("/productos")
public class ProductoRestController {

	private final ProductoRepository repository;
	
	@Autowired
	public ProductoRestController(ProductoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Producto> getProductos() {
		return repository.findAll();
	}
	
	@GetMapping("/{marca}")
	public List<Producto> getProductosByMarca(@PathVariable("marca") String marca) {
		return repository.findAllByMarcaNombre(marca);
	}
	
}
