(function () {
    'use strict';

    var App = angular.module('myApp', [])
        .controller('ctrl', ['$scope', '$http', function ($scope, $http) {
            $http.get('http://localhost:9090/api/productos')
                .then(function (response) {
                    $scope.productos = response.data;
                });
        }]);
})();