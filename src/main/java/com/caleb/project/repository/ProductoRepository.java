package com.caleb.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caleb.project.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	List<Producto> findAllByMarcaNombre(String marca);
	
}
