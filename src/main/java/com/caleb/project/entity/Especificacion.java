package com.caleb.project.entity;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the tbl_especificacion database table.
 * 
 */
@Entity
@Table(name="tbl_especificacion")
public class Especificacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private String almacenamiento;

	private String banda;

	private String bateria;

	private String camara;

	private String conectividad;

	private String dimension;

	@SuppressWarnings("unused")
	private String marca;

	private String modelo;

	private String pantalla;

	private String peso;

	private String ram;

	private String sim;

	private String so;

	//bi-directional many-to-one association to Producto
	@OneToOne
	@JoinColumn(name="id_producto", insertable=false, updatable=false)
	private Producto producto;

	public Especificacion() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlmacenamiento() throws IOException  {
		return this.almacenamiento;
	}

	public void setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public String getBanda() {
		return this.banda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

	public String getBateria() {
		return this.bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}

	public String getCamara() {
		return this.camara;
	}

	public void setCamara(String camara) {
		this.camara = camara;
	}

	public String getConectividad() {
		return this.conectividad;
	}

	public void setConectividad(String conectividad) {
		this.conectividad = conectividad;
	}

	public String getDimension() {
		return this.dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPantalla() {
		return this.pantalla;
	}

	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}

	public String getPeso() {
		return this.peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getRam() {
		return this.ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getSim() {
		return this.sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getSo() {
		return this.so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}