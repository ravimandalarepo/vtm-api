   ( function(){
	'use strict'
	angular
	.module('runbus')
	.controller('SmsController', SmsController);
	
	SmsController.$inject = ['UserService'];
	
	function SmsController(UserService){	
		var vm =  this;
		vm.sendSMS = sendSMS;
		alert("CSMS COntroller");
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