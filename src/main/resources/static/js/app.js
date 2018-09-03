var app = angular
            .module('app', [
                'ngRoute',
                'ngResource',
                'ngAnimate',
                'ui.bootstrap'
            ])
            .config(function($routeProvider){
                $routeProvider
                    .when('/',{
                        controller: 'TypeAheadController'
                    })
                    .otherwise(
                        { redirectTo: '/'}
                    );
                }
            );