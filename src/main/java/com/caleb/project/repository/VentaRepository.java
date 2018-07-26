package com.caleb.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caleb.project.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

	List<Venta> findAllByClienteIdCliente(int idCliente);
	
}
