(function() {
	var app = angular.module("zhang-app", []).controller(
			'courseController',
			function($scope, $rootScope) {

				$scope.search = ''

				$scope.list = []
				$scope.selectedList = []

				$scope.selectVal = function(event) {
					$scope.search = this.course.kurzname
				}

				$scope.selectCourse = function(event) {
					// update the courselist in rootScope
					$rootScope.courseList = []
					for ( var i in $scope.list) {
						if ($scope.list[i].selected) {
							$rootScope.courseList.push($scope.list[i])
						}
					}
					// save in localstorage
					localStorage.coursesjo = JSON
							.stringify($rootScope.courseList);
				}

				$rootScope.courseList = []

				try {
					$rootScope.courseList = JSON.parse(localStorage.coursesjo)
				} catch (e) {
					$rootScope.courseList = []
				}

				for ( var i in initCourses) {
					var temp = initCourses[i]
					temp.id = i
					// if selected apply
					for ( var j in $rootScope.courseList) {
						if ($rootScope.courseList[j].id == temp.id) 
							temp.selected = true
					}
					$scope.list.push(temp)
				}
				//$scope.list = initCourses
				//$scope.$apply()

				localStorage.setItem("courselistlength", $rootScope.courseList.length);	// give list length to be able to set number of prios to be selected in priorities.js
			})
})()
