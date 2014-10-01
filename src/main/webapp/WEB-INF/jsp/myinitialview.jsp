<!DOCTYPE html>
<html ng-app="myApp">
<head>
</head>
<body ng-controller="EmployeeCtrl">

<h2>My pathetic employee manager</h2>

<table>
   <tr ng-repeat="employee in employees">
    <td><input type="radio" ng-model="$parent.editedEmployee" ng-value="employee">{{ employee.id }}</td>
    <!--  I do not like the $parent reference but I had to hack it - see why:  http://odetocode.com/blogs/scott/archive/2013/06/25/radio-buttons-with-angularjs.aspx -->
    <td>{{ employee.name }}</td>
    <td>{{ employee.jobTitle }}</td>
    <td><button ng-click="deleteEmployee(employee.id)">Delete</button></td>
  </tr>
</table>
<button ng-click="addEmployee()">Add</button>

<div ng-show="editedEmployee">
   Id: <input type="text" ng-model="editedEmployee.id">
   name: <input type="text" ng-model="editedEmployee.name">
   job: <input type="text" ng-model="editedEmployee.jobTitle">
   <button ng-click="saveEmployee(editedEmployee)">Save</button>
   
</div>

  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-resource.js"></script>
  <script src="js/controllers.js"></script>

</body>
</html>