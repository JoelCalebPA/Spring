'use strict';

angular.module('myApp').controller('ProductoController', ['ProductoService'], function($scope, ProductoService) {
    
    var self = this;
    
    self.marca={id_marca:null,nombre:'',descripcion:''};
    self.especificacion={almacenamiento:'',camara:'',ram:''};
    self.producto={id_producto:null,marca:self.marca,descripcion:'',detalle:'',stock:'',precio:null,calificacion:null,descuento:null,especificacion:self.especificacion};
    self.productos=[];

	self.listar = listar;
	
    listarProductos();
    
    function listarProductos(){
        ProductoService.listarProductos()
            .then(
            function(d) {
                self.productos = d;
            },
            function(errResponse){
                console.error('Error al obtener el listado de productos');
            }
        );
    }
	
});