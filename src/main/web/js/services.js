angular.module('eventsApp.services', [])
    .factory('Event', function ($resource) {
        return $resource('http://localhost:8080/event/:id', {id: '@id'}, {
            update: {
                method: 'PUT'
            }
        });
    })
    .factory('Events', function ($resource) {
        return $resource('/event/list')
    })
    .service('popupService', function ($window) {
        this.showPopup = function (message) {
            return $window.confirm(message);
        }
    });