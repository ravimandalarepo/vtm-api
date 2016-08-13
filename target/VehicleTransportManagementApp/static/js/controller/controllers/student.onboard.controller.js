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
		vm.getPickupDetails = getPickupDetails;
		vm.displayStudentDetails = displayStudentDetails;
		alert("In Pickup");
		getPickupDetails(1);
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
	function getPickupDetails(id) {
		alert("Hd");
		vm.displayStudentDetails = displayStudentDetails;
		var pickuppoint;
		UserService.getPickupDetails(id).then(
			function(res) {
			vm.pickupPoints=res.data;
			pickuppoint=vm.pickupPoints[0].pickupPointId;
				alert(vm.pickupPoints[0].pickupPointId);
				vm.displayStudentDetails(pickuppoint);
			//	$('#student_'+id).parents('.media').addClass('boarded');
			}
		);
		
		console.log(id);
		
			
		}	
	function displayStudentDetails(id) {
		alert("Display student details-->");
		UserService.displayStudentDetails(id).then(
			function(res) {
			vm.students=res.data.students;
				alert(vm.students[0].firstName);
			
			//	$('#student_'+id).parents('.media').addClass('boarded');
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
		
	}

})()