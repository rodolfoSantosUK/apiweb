//Criação do modulo principal da apicação 
var appCliente = angular.module("appCliente", []);

appCliente.controller("indexController", function($scope, $http) {

	$scope.clientes = [];
	$scope.cliente = {};

	$scope.carregarClientes = function() {
		$http({
			method : 'GET',url : 'http://localhost:4141/clientes'
		}).then(function(response) {
			$scope.clientes = response.data;
			console.log(response.data);
		}, function(response) {
			console.log(response.data);
		});
	}

	$scope.carregarClientes();

	$scope.salvarCliente = function() {
		$http({
			method : 'POST', url : 'http://localhost:4141/cliente',
			data : $scope.cliente
		}).then(function(response) {
			$scope.clientes.push(response.data);
			console.log(response.data);
		}, function(response) {
			console.log(response.data);
		});
	}

	$scope.excluirCliente = function(cliente) {
		$http({
			method : 'DELETE', url : 'http://localhost:4141/clientes/' + cliente.id
		}).then(function(response) {

			pos = $scope.clientes.indexOf(cliente);
			$scope.clientes.splice(pos, 1);
			console.log(response.data);

		}, function(response) {
			console.log(response.data);
		});
	}

	
	
	
})
