/**
 * Created by Sandeep on 01/06/14.
 */

angular.module('movieApp',['ui.router','ngResource','movieApp.controllers','movieApp.services']);

angular.module('movieApp').config(function($stateProvider,$httpProvider){
    $stateProvider.state('events',{
        url:'/events',
        templateUrl:'partials/movies.html',
        controller:'MovieListController'
    }).state('viewMovie',{
       url:'/events/:id/view',
       templateUrl:'partials/movie-view.html',
       controller:'MovieViewController'
    }).state('newMovie',{
        url:'/events/new',
        templateUrl:'partials/movie-add.html',
        controller:'MovieCreateController'
    }).state('editMovie',{
        url:'/events/:id/edit',
        templateUrl:'partials/movie-edit.html',
        controller:'MovieEditController'
    });
}).run(function($state){
   $state.go('events');
});