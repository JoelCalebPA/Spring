angular.module('myApp', [])
    .controller('ctrl', function ($scope, $http) {
        $http.get('http://localhost:8080/api/productos')
            .then(function (response) {
                $scope.productos = response.data;
            });
    });