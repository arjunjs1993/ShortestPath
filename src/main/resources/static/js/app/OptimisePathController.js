'use strict'

var module = angular.module('path.controllers', []);
module.controller("OptimisePathController", [ "$scope", "OptimisePathService",
	function($scope, OptimisePathService) {

	$scope.pathDTO={
			numOfNodes:'',
			adjacencyMatrix :null,
			optimalPath:null,
			optimalTotalDistance:''
	};

	$scope.optimisePath = function() {
	OptimisePathService.optimalPath($scope.pathDTO).then(function(value) {
		console.log(value.data);
		$scope.pathDTO.optimalPath=value.data.optimalPath;
		$scope.pathDTO.optimalTotalDistance=value.data.optimalTotalDistance;
	}, function(reason) {
		console.log("error occured");
	}, function(value) {
		console.log("no callback");
	});

	}
} ]);