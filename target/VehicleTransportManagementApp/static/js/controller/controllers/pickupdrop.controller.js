( function () {
	'use strict'

	angular
	.module('runbus')
	.controller('PickUpDropController', PickUpDropController);

	PickUpDropController.$inject = ['$location', '$rootScope', 'FlashService','$http', '$filter'];
	function PickUpDropController( $location, $rootScope, FlashService, $http, $filter ) {
		var vm = this;
	  	vm.SetLocation = SetLocation;
	  	//vm.displayRoute=displayRoute;
  		var date = new Date();
  			vm.HHmmss = $filter('date')(new Date(), 'HH:mm');
    	vm.date = $filter('date')(new Date(), 'EEEE, MMMM dd yyyy');
    	console.log("Hello in pickup");
    	SetLocation($http);
	  	function SetLocation($http) { 
	  	$http.get("http://localhost:8080/vtm/routes")
    .then(function(response) {
    vm.routes=response.data;
        //alert(vm.routes[0].name);
    });
	  		
            console.log( $('.pick-up').text() );
	        console.log( $('.drop-off').text() );
	        sessionStorage.setItem('pick-up', $('.pick-up').text());
	        sessionStorage.setItem('drop-off', $('.drop-off').text());
	    }
		 vm.displayRoute=function() { 
		 //vm.DropDownStatus = vm.dropValue;
		vm.DropDownStatus= $( "#UserSelector" ).val();;
	  	//alert("hello boss"+vm.DropDownStatus);
	  	$http.get("http://localhost:8080/vtm/route/"+vm.DropDownStatus)
    .then(function(response) {
    vm.route=response.data;
      
    });
	    }

 vm.directView=function() { 
		 //vm.DropDownStatus = vm.dropValue;
	//	vm.DropDownStatus= $( "#UserSelector" ).val();;
	  	//alert("hello boss"+vm.DropDownStatus);
	  	//$http.get("http://localhost:8080/vtm/route/"+vm.DropDownStatus)
   // .then(function(response) {
   // vm.route=response.data;
      
 //   });
	    }

	}

})();