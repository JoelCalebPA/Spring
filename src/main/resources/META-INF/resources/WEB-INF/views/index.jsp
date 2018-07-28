<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="myApp">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World!!!</h1>
	<div ng-controller="ProductoController as ctrl">
		<table>
			<tbody>
				<tr ng-repeat="p in ctrl.productos">
					<td><span ng-bind="p.id_producto"></span></td>
					<td><span ng-bind="p.descripcion"></span></td>
					<td><span ng-bind="p.precio"></span></td>
					<td><span ng-bind="p.stock"></span></td>
					<td><span ng-bind="p.marca.nombre"></span></td>
				</tr>
			</tbody>
		</table>
	</div>
	<script src="/webjars/angularjs/1.4.9/angular.js"></script>
	<script src="/js/app.js"></script>
	<script src="/js/producto_controller.js"></script>
	<link rel="stylesheet"
		href="/webjars/bootstrap/3.3.6/css/bootstrap.css">
</body>
</html>