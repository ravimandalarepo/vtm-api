(function () {
    'use strict';

    angular
        .module('runbus')
        .factory('UserService', UserService);

    UserService.$inject = ['$timeout', '$filter', '$q', '$http', '$location'];
    function UserService( $timeout, $filter, $q, $http, $location ) {
        var service = {};

        

        return service;

   

    }
})();