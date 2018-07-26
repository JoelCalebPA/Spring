package com.caleb.project.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_detalle_venta database table.
 * 
 */
@Entity
@Table(name="tbl_detalle_venta")
@NamedQuery(name="DetalleVenta.findAll", query="SELECT d FROM DetalleVenta d")
public class DetalleVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleVentaPK id;

	private int cantidad;

	private int precio;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto", insertable=false, updatable=false)
	private Producto producto;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="id_venta", insertable=false, updatable=false)
	private Venta venta;

	public DetalleVenta() {
	}

	public void setId(DetalleVentaPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getProducto() {
		return this.producto.getDescripcion();
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}