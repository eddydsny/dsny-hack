(function () {
	angular.module('app')
		.controller('appController', ['$scope', appController]);

	function appController ($scope) {

		// get events from server

		function getEvents () {
			return [];
		}

		$scope.events = getEvents();

	}

}())
