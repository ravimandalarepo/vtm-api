( function () {
	'use strict'

	angular
	.module('runbus')
	.controller('MapViewController', MapViewController);

	MapViewController.$inject = ['$location', '$rootScope', 'FlashService','$http', '$filter'];
	function MapViewController( $location, $rootScope, FlashService, $http, $filter ) {
		var vm = this;
	  	vm.displayRoute = displayRoute;
	  	//vm.displayRoute=displayRoute;
  		var date = new Date();
  		alert("Hello in ctrl view");
    	vm.HHmmss = $filter('date')(new Date(), 'HH:mm');
    	vm.date = $filter('date')(new Date(), 'EEEE, MMMM dd yyyy');
    	console.log("Hello in pickup");
    	displayRoute($http);
	 function displayRoute($http) { 
		vm.DropDownStatus= $( "#UserSelector" ).val();;
	  	alert("hello boss in view"+vm.DropDownStatus);
	  	$http.get("http://localhost:8080/vtm/route/"+vm.DropDownStatus)
    .then(function(response) {
    vm.route=response.data;
    alert(vm.route.name);
      
    });
	    }

	}

})();