( function(){
	'use strict'
	angular
	.module('runbus')
	.controller('ViewDirectionController', ViewDirectionController);
	
	ViewDirectionController.$inject = ['UserService'];
	
	function ViewDirectionController(UserService){	
		var vm =  this;
		vm.getPickupDetails = getPickupDetails;
		alert("In Pickup direct");
		getPickupDetails(1);
		function getPickupDetails(id) {
		alert("Hdentello stu");
		UserService.getPickupDetails(id).then(
			function(res) {
			vm.pickupPoints=res.data;
				alert(vm.pickupPoints[0].pickupPointName);
			
			//	$('#student_'+id).parents('.media').addClass('boarded');
			}
		);
		console.log(id);
			
		}
	
	
	}

})()