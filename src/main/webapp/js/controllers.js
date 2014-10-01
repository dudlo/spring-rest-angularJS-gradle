var myApp = angular.module('myApp', []);

myApp.factory("Employee", function() {
	   // Define the constructor function.
	   function Employee(id, name, job) {
		   this.id = id;
		   this.name = name;
		   this.jobTitle = job;
	   }
	   // Return constructor - this is what defines the actual injectable in the DI framework.
	   return Employee;	
	}
	);

myApp.controller('EmployeeCtrl', ['$scope', '$http', '$log', 'Employee',
  function ($scope, $http, $log) {
// works - hardwired:   $scope.employees = [{'id': 'fake', 'name': 'Jim Fake','jobTitle': 'lazyboy'}];
	$scope.refreshEmployees = function() {
		$http.get('rest/employees').success(function(data) {
		    $scope.employees = data;
		  });
		// TODO: We should check if editedEmployee is present in the new employees. If not we should null out the value (as opposed to brute force we do here).
		$scope.editedEmployee = null;
	}
	$scope.refreshEmployees();
	$scope.saveEmployee = function(employee) {
	    // $log.info('Pressed save: ' + employee);
		// TODO: We should check if this is new or existing employee and call create() (POST) when new
	    $http.put('rest/employees/' + employee, employee).success(function(data) {
		    $scope.refreshEmployees();
		  });
	}
	$scope.deleteEmployee = function(employeeId) {
	    // $log.info('Pressed delete: ' + employeeId);
	    $http.delete('rest/employees/' + employeeId).success(function(data) {
		    $scope.refreshEmployees();
		  });
	}
	$scope.addEmployee = function() {
		$scope.editedEmployee = {id:"new", name: "Ann", jobTitle: "CEO"};    // Bloody mess - I do not know how to create a new instance using:   new Employee("new", "Ann", "CEO");
	    // note this only populates the form fields; it needs to be saved to make it to the server
	}
}]);
