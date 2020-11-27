var app = angular.module('myApp', [ 'ng-route' ]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
      templateUrl : "index.html"
    })
    .when("/accountpage", {
      // templateUrl : "accounts.html"
        template : "<h1>Account Page</h1>"
    })
    .when("/green", {
      // templateUrl : "green.htm"
      template : "<h1>Green</h1>"
    })
    .when("/blue", {
      // templateUrl : "blue.htm"
      template : "<h1>BLUEEEEEEEEEE</h1>"
    });
  });