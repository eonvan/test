var app = angular.module('app', ['ui.bootstrap']);

app.controller('home', function($scope, $http) {
    $scope.creditApplication = {"id":0, "applicantName":"", "bank": "", "rating":0, "status":""};
    //$scope.appId = 0;
    $scope.processForm  = function() {
    	var ret = $http.post('/start-credit-process',$scope.creditApplication).
    	then(function(response) {
    		console.log("response = " + JSON.stringify(response.data));
    		$scope.creditApplication = response.data;
    	},
    	function(response) {
    		$scope.errorMsg = 'Request failed';
    	});
    };		
    $scope.refreshForm = function() {
    	var ret = $http.get('/application/' + $scope.creditApplication.id).
    	then(function(response) {
    		$scope.creditApplication = response.data;
    		console.log("Retrieved application for " + $scope.creditApplication.id);
    	}, function(response) {
    		$scope.errorMsg = 'Request failed';
    	});
    };
    $scope.clearForm = function() {
        $scope.creditApplication = {"id":0, "applicantName":"", "bank": "", "rating":0, "status":""};    	
    };
});