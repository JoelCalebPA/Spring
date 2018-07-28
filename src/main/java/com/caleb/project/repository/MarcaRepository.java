package com.caleb.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caleb.project.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
