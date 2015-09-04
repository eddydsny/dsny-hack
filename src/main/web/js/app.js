
angular.module('eventsApp',['ui.router','ngResource','eventsApp.controllers','eventsApp.services']);

angular.module('eventsApp').config(function($stateProvider,$httpProvider){
    $stateProvider.state('events',{
        url:'/events',
        templateUrl:'/partials/events',
        controller:'EventListController'
    }).state('viewEvent',{
       url:'/events/:id/view',
       templateUrl:'partials/event-view',
       controller:'EventViewController'
    }).state('newEvent',{
        url:'/events/new',
        templateUrl:'partials/event-add',
        controller:'EventCreateController'
    }).state('editEvent',{
        url:'/events/:id/edit',
        templateUrl:'partials/event-edit',
        controller:'EventEditController'
    });
}).run(function($state){
   $state.go('events');
});