( function(){
	'use strict'
	angular
	.module('runbus')
	.controller('StundentOnboardController', StundentOnboardController);
	
	StundentOnboardController.$inject = ['UserService'];
	
	function StundentOnboardController(UserService){	
		var vm =  this;
		vm.StudentRsvp = StudentRsvp;
		vm.sendSMS = sendSMS;
		vm.getPickupDetails=getPickupDetails;
		alert("In Pickup");
		function StudentRsvp(id) {
		alert("Hdentello stu");
		UserService.StudentRsvp(id).then(
			function(res) {
				console.log(res);
			
				$('#student_'+id).parents('.media').addClass('boarded');
			}
		);
		console.log(id);
			
		}
	
	function sendSMS(id) {
		alert("Hello");
		UserService.sendSMS(id).then(
			function(res) {
				console.log(res);
			
				//$('#student_'+id).parents('.media').addClass('boarded');
			}
		);
		console.log(id);
			
		}
		function getPickupDetails() {
		alert("Hello");
					
		}
	}

})()