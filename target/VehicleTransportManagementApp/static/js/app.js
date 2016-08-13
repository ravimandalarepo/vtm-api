(function () {
    'use strict';

    angular
        .module('runbus', ['ngRoute', 'ngCookies', 'ngAnimate'])
        .config(config)
        .run(run);


    config.$inject = ['$routeProvider', '$locationProvider', '$httpProvider'];
   
    function config($routeProvider, $locationProvider, $httpProvider) {
         $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
      
        // $httpProvider.defaults.headers.common['Authorization'] = 'Bearer ' + globals.currentUser.authtoken;
        $routeProvider
         

            .when('/', {
                controller:'PickUpDropController',
                templateUrl: 'static/templates/map.html',
                controllerAs: 'vm'
            })
            .when('/direction', {
                controller:'MapViewController',
                templateUrl: 'static/templates/map.view.html',
                controllerAs: 'vm1'
            }) 
            .when('/onboard', {
                controller:'ViewDirectionController',
                templateUrl: 'static/templates/on-board.view.html',
                controllerAs: 'vm'
            }) 
            .when('/map', {
               // controller:'StundentOnboardController',
                templateUrl: 'static/templates/view-direction.html',
                controllerAs: 'vm'
            })

            

           .otherwise({ redirectTo: '/' });

            // $locationProvider.html5Mode(false).hashPrefix('!');
           // $locationProvider.html5Mode(true);
           // delete $httpProvider.defaults.headers.common['X-Requested-With'];
           // $httpProvider.defaults.headers.common['Authorization'] = 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZ2FubmFiYXR0dWxhQGdhbHRzb2Z0LmluIiwicm9sZXMiOlt7InJvbGVJZCI6MTEsImNvbXBhbnlJZCI6bnVsbCwiZGVzY3JpcHRpb24iOiJJbmZvZyBncHMgYWRtaW4gdG8gcHJvdmlzaW9uIGNvbXBhbnkgYW5kIGluaXRhaWwgY29tcGFueSBhZG1pbiBhbmQgdXNlcnMiLCJkaXNjcmltaW5hdG9yIjoiU1lTVEVNIiwibmFtZSI6ImluZm9ncHNfYWRtaW4iLCJjcmVhdGVkQnkiOm51bGwsImNyZWF0ZWRUaW1lIjpudWxsLCJhcHBQZXJtaXNzaW9uVmFsdWVzIjpudWxsLCJhcHBVc2VycyI6bnVsbH1dLCJpYXQiOjE0NDIzOTQzNjN9.kffwH3eSKvBRqAjN4JZcldR1FTKHid1Zx09aOycSX-o'; // jshint ignore:line
    }

    function ClearStorage() {
       
    }

    run.$inject = ['$rootScope', 'UserService', '$location', '$cookieStore', '$http'];
    function run( $rootScope, UserService, $location, $cookieStore, $http ) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
       
        if ( $rootScope.globals.currentUser ) {
           $http.defaults.headers.common['Authorization'] = 'Bearer ' + $rootScope.globals.currentUser.authtoken; // jshint ignore:line
          //  $http.defaults.headers.common['Authorization'] = 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZ2FubmFiYXR0dWxhQGdhbHRzb2Z0LmluIiwicm9sZXMiOlt7InJvbGVJZCI6MTEsImNvbXBhbnlJZCI6bnVsbCwiZGVzY3JpcHRpb24iOiJJbmZvZyBncHMgYWRtaW4gdG8gcHJvdmlzaW9uIGNvbXBhbnkgYW5kIGluaXRhaWwgY29tcGFueSBhZG1pbiBhbmQgdXNlcnMiLCJkaXNjcmltaW5hdG9yIjoiU1lTVEVNIiwibmFtZSI6ImluZm9ncHNfYWRtaW4iLCJjcmVhdGVkQnkiOm51bGwsImNyZWF0ZWRUaW1lIjpudWxsLCJhcHBQZXJtaXNzaW9uVmFsdWVzIjpudWxsLCJhcHBVc2VycyI6bnVsbH1dLCJpYXQiOjE0NDIzOTQzNjN9.kffwH3eSKvBRqAjN4JZcldR1FTKHid1Zx09aOycSX-o'; // jshint ignore:line
        }

        $( '#current_user' ).text( sessionStorage.getItem( 'CurrentUser' ) );
        $( '.top-nav' ).removeClass( 'hide' );   
        
        $rootScope.$on( '$locationChangeStart', function ( event, next, current ) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray( $location.path(), ['/login', '/register'] ) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            var token = sessionStorage.getItem('token');
           
            // if ( !loggedIn || !token ) {
            //     ClearStorage();                 
            //     $location.path('/login'); 
            // }
        });
    }
})();
