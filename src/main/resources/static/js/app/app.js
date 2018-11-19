'use strict'

var pathApp = angular.module('path', [ 'ui.bootstrap', 'path.controllers',
		'path.services' ]);
pathApp.constant("CONSTANTS", {
	optimalPath : "/path/optimalPath"
});