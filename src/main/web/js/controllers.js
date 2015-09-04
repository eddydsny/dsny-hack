/**
 * Created by Sandeep on 01/06/14.
 */
angular.module('eventsApp.controllers',[]).controller('EventListController',function($scope,$state,popupService,$window,Event){

    $scope.events=Event.query();

    $scope.deleteEvent=function(event){
        if(popupService.showPopup('Really delete this?')){
            event.$delete(function(){
                $window.location.href='';
            });
        }
    }

}).controller('EventViewController',function($scope,$stateParams,Event){

    $scope.event=Event.get({id:$stateParams.id});

}).controller('EventCreateController',function($scope,$state,$stateParams,Event){

    $scope.event=new Event();

    $scope.addEvent=function(){
        $scope.event.$save(function(){
            $state.go('event/list');
        });
    }

}).controller('EventEditController',function($scope,$state,$stateParams,Event){

    $scope.updateEvent=function(){
        $scope.event.$update(function(){
            $state.go('events');
        });
    };

    $scope.loadEvent=function(){
        $scope.event=Event.get({id:$stateParams.id});
    };

    $scope.loadEvent();
});