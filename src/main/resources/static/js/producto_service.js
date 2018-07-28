'use strict';

angular.module('myApp').factory('ProductoService', ['$http', '$q', function($http, $q){
	
	var REST_SERVICE_PRODUCTO = 'http://localhost:8080/api/productos';
	
	var factory = {
		listarProductos:listarProductos
	};
	
	return factory;

	function listarProductos() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_PRODUCTO)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error al obtener el listado de productos');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
	}
	
}])