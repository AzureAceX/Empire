angular.module("myApp").factory("Accounts", function($http) {


	var listAccounts = function(cb) {
		$http({
			method : 'GET',
			url : 'http://localhost:8761/account/list',
		}).success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
			cb(null, data);
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			cb(data);
		});
	}

	var getAccount = function(cb) {
		$http({
			method : 'GET',
			url : 'http://localhost:8761/account/get/',
		}).success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
			cb(null, data);
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			cb(data);
		});
	}








	// 

	var getRecipes = function(cb) {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/cookrecipe/category',
		}).success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
			cb(null, data);
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			cb(data);
		});
	}

	var postRecipe = function(cb, data) {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/cookrecipe/recipe',
			data : data,
		}).success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
			cb(null, data);
		}).error(function(data, status, headers, config) {
			cb(data);
		});

	}

	var putRecipe = function(data, cb) {
		$http({
			method : 'PUT',
			url : 'http://localhost:8080/cookrecipe/recipe',
			data : data,
		}).success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
			cb(null, data);
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			cb(data);
		});
	}

	var deleteRecipe = function(id, cb) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/cookrecipe/recipe/' + id,
		}).success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
			cb(null, data);
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			cb(data);
		});
	}

	var deleteIngs = function(iid, cb) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/cookrecipe/recipe/ingredient/' + iid,
		}).success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
			cb(null, data);
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			cb(data);
		});
	}

	var deleteSteps = function(sid, cb) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/cookrecipe/recipe/step/' + sid,
		}).success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
			cb(null, data);
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			cb(data);
		});
	}

	return {
		listAccounts : listAccounts,
		getAccount : getAccount, 
		// updateAccount : updateAccount,
		getRecipes : getRecipes,
		postRecipe : postRecipe,
		putRecipe : putRecipe,
		deleteRecipe : deleteRecipe,
		deleteIngs : deleteIngs,
		deleteSteps : deleteSteps

	}

});
