package com.caleb.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caleb.project.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	
}
