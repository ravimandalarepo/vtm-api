(function () {
    'use strict';

    angular
        .module('runbus')
        .factory('UserService', UserService);

    UserService.$inject = ['$http'];
    
    function UserService($http) {
        var customUrl = sessionStorage.getItem('customUrl');
        var service = {};

        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;
        service.sendSMS=sendSMS;
        service.StudentRsvp = StudentRsvp;
		service.getPickupDetails=getPickupDetails;
        return service;
        
       
        function StudentRsvp(studentId) {
           return $http.post('/api/users', studentId).then(handleSuccess, handleError('Error creating user'));
        
        }
		 function getPickupDetails(studentId) {
		 alert(studentId);
           return $http.get('http://localhost:8080/vtm/pickuppoints/'+studentId).then(handleSuccess, handleError('Error creating user'));
        
        }
		function sendSMS(routeId) {
		alert("SMS Sent-->"+routeId);
            return $http.post('http://localhost:8080/vtm/route/sms', routeId).then(handleSuccess, handleError('Error creating user'));
        }
        function Create(user) {
            return $http.post('/api/users', user).then(handleSuccess, handleError('Error creating user'));
        }

        function Update(user) {
            return $http.put('/api/users/' + user.id, user).then(handleSuccess, handleError('Error updating user'));
        }

        function Delete(id) {
            return $http.delete('/api/users/' + id).then(handleSuccess, handleError('Error deleting user'));
        }


        // private functions

        function handleSuccess(data) {
            return data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
