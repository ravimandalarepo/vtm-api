(function () {
    'use strict';

    angular
        .module('runbus')
        .factory('FlashService', FlashService);

    FlashService.$inject = ['$rootScope'];
    function FlashService($rootScope) {
        var customUrl = sessionStorage.getItem('customUrl');
        var service = {};

        service.Success = Success;
        service.Error = Error;

        initService();

        return service;


function displayRoute(routeId) {
alert("ravi");
           return $http.post('/api/users', studentId).then(handleSuccess, handleError('Error creating user'));
        
        }
        function initService() {
            $rootScope.$on('$locationChangeStart', function () {
                clearFlashMessage();
            });

            function clearFlashMessage() {
                var flash = $rootScope.flash;
                if (flash) {
                    if (!flash.keepAfterLocationChange) {
                        delete $rootScope.flash;
                    } else {
                        // only keep for a single location change
                        flash.keepAfterLocationChange = false;
                    }
                }
            }
        }

        function Success(message, keepAfterLocationChange) {
            $rootScope.flash = {
                message: message,
                type: 'success', 
                keepAfterLocationChange: keepAfterLocationChange
            };
        }

        function Error(message, keepAfterLocationChange) {
            $rootScope.flash = {
                message: message,
                type: 'error',
                keepAfterLocationChange: keepAfterLocationChange
            };
        }

        // function PrevelegedMarkup() {
        //  alert('Ravi');
        // } 
    }

})();