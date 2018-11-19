'use strict'

angular.module('path.services', []).factory('OptimisePathService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.optimalPath = function(pathDTO) {
				return $http.post( CONSTANTS.optimalPath, pathDTO);
			}
			return service;
		} ]);