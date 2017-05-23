(function() {
  var app = angular.module("zhang-app").controller('prioController', function($scope, $rootScope) {

	var numberOfPriosSelected = 0; 
	var maxNumberOfPriosSelected = 10;
	var alreadySeletedPrio = false;
//	var alreadySeletedPrioTextfield = false;
	
    $scope.selectPrio = function(index, prio) {
    	// TODO: check all the priorities for validating issues
//    	for(var i in $rootScope.selectedPriorities) {
	    
    	// TODO: herausbekommen ob schonmal hinzugefügt
    	// TODO: when showSourses == false -> nur 1x auswählbar
//   	    if (($rootScope.selectedPriorities[i].showCourses == true) || ((showCourses == false) && (not selected before)))
//   	    	
//   	    }
//	    }
    	if ((numberOfPriosSelected < maxNumberOfPriosSelected) && (!alreadySeletedPrio)) {
    		
	    		for(var i in $rootScope.selectedPriorities) {
	    	        $rootScope.selectedPriorities[i].hideContent = true;
	    	    }
	    	    var newPrio = jQuery.extend(true, {}, prio);
	    	    newPrio.origin = index;
	    	    $rootScope.selectedPriorities.unshift(newPrio);  
	    	    numberOfPriosSelected++;
//    		}    
    	} 
    	else {
    		// TODO: print error massage on screen "You can only select 10 wishes"
    	}
    }

    $scope.removeEntry = function(index, prio) {
      var newPrios = [];
      for(var i in $rootScope.selectedPriorities) {
        if(i == index) continue;
        newPrios.push($rootScope.selectedPriorities[i]);
      }
      $rootScope.selectedPriorities = newPrios;
      
      numberOfPriosSelected--;
    }

    $rootScope.selectedPriorities = [];

    $scope.save = function() {
	      
	    // validating selected prios -> TODO: only save prios when validated and okay
 
    	var noEmptyInputElements = true;
    	var noImpossibleCombinations = true;
    	var noDublication = true;
    	var calendarIsNotEmpty = true;
    	
    	for(var i in $rootScope.selectedPriorities) {
    		
	    	// check if prio inputs are empty
	   	    if ($rootScope.selectedPriorities[i].type == "FreeTextInput") {
	    		if (document.getElementById("freeTextWish").value == "") 
	    			noEmptyInputElements = false; //console.log("text area is empty");
	    	}
	   	    // TODO: check if options are not selected
//	    	console.log("option: " + $rootScope.selectedPriorities[i].option.value); 
	    	
//	   	 	$("select")				// get all selects
//	   	    if($("select").val()){	// any option selected?
	    	var selects = document.getElementsByTagName('select');

			for(var i = 0; i < selects.length; i++) {
				if (selects[i].value == "? undefined:undefined ?") {
					noEmptyInputElements = false;
			    }
			}
	    	
	    	
	    		// else noEmptyInputElements = false;
	    	
//  	  	var conent = $rootScope.priority-conent ;
//	  	   !$rootScope.selectedPriorities.option //.value // .select - not working
//	   		$rootScope.selectedPriorities.dayOne.value == [0, 0]
//	   		$rootScope.selectedPriorities.dayTwo.value == [0, 0] 
//	     	!$rootScope.selectedPriorities.course.isSelected()
	    	
	    	
	    	
	    	
	    	// TODO: check if some of the inputs are impossible to combine
	    		// else noImpossibleCombinations = false
	    	
	    	
	    	
	    	// TODO: check for duplication on raumbeschaffenheit & 2sws wöchentlich
	   	    	// else noDublication = false;
	    	    
    	}

    	// TODO: check if calendar is Selected (at least min, at most max) ?
    			// else calendarIsNotEmpty = false;
    	
        	
    

	      
        
//      try {	} catch { }
//  	$rootScope.selectedPriorities.ExcludeDayCombinationPrio
	      
	      

	    // if all fine -> save	  
    	if (noEmptyInputElements && noImpossibleCombinations && noDublication && calendarIsNotEmpty) {
    		
//	      console.log('Save:', $rootScope.selectedPriorities);
	      
	      $.ajax({
	        type: 'POST',
	        contentType : 'application/json; charset=utf-8',
	        url: '/ZhangProjectBackend/post.json',
	        data: JSON.stringify($rootScope.selectedPriorities),
	        success: function(response) {
	          console.log('Response', response);
	        },
	        error: function(response) {
	          console.error('Response', response);
	        }    
	      });
    	}
    	else {
    		// TODO: error message telling the user what needs to be changed - like "please check that  you choose any of the options..."
    	}
    }
   
    $scope.possiblePriorities = [
      {
        type: 'SingleChoicePrio',				
        title: 'Raumbeschaffenheit',
        options: ['breite','lange'],
        text: ['Ich bevorzuge ', ' Räume'],		// mehrfachauswahl - kursabhängig <-> kursunabhängige: nur einfachauswahl erlauben 
        showCourses: true						
      },
      {
        type: 'SingleChoicePrio',				// einfachauswahl
        title: 'Unterrichtsbeginn',
        options: ['früher','später'],
        text: ['Innerhalb der von mir angegebenen Belegzeiten bevorzuge ich den Unterrichtsbeginn je', 'desto besser.'],
        showCourses: false						
      },
      {
        type: 'SingleChoicePrio',				// einfachauswahl
        title: 'Anzahl Veranstaltungen pro Tag',
        options: ['mehr Veranstaltungen pro Tag, weniger Tage die Woche','weniger Veranstaltungen pro Tag, mehr Tage die Woche'],
        text: ['Ich bevorzuge ', '.'],
        showCourses: false
      },
      {
        type: 'SimplePrio',						// mehrfachauswahl
        title: 'Wöchentliche Veranstaltungen',
        text: 'Ich ziehe es vor die vierzehntägigen 4SWS meines Unterrichts in zwei wöchentliche Einzelveranstaltungen mit je 2SWS aufzuteilen.',
        showCourses: true
      },
      {
        type: 'ExcludeDayCombinationPrio',		// einfachauswahl
        title: 'Tage ausschließen',
        text: ['Wenn ich am ',' unterrichte, möchte ich nicht am ',' unterrichten.'],
        showCourses: false
      },
      {
        type: 'ExcludeDayCombinationPrio',		// einfachauswahl
        title: 'Uhrzeit ausschließen',
        text: ['Wenn ich am ',' um ',' unterrichte, möchte ich nicht am ',' um ',' unterrichten.'],
        showCourses: false					
      },
      {
        type: 'ExcludeDayCombinationPrio',		// einfachauswahl
        title: 'Tage kombinieren',
        text: ['Wenn ich am ',' unterrichte, möchte ich auch am ',' unterrichten.'],
        showCourses: false						
      },
      {
        type: 'SingleChoicePrio',				// einfachauswahl
        title: 'Pausen',
        options: ['1','2','3','4','5'],
        text: ['Ich möchte nach spätestens ',' aufeinanderfolgenden Vorlesungen eine längere Pause. Die Mittagspause zwischen 11:15 und 12:15 wird als längere Pause gezählt.'],
        showCourses: false
      },
      {
        type: 'SingleChoicePrio',				// einfachauswahl
        title: 'Maximale Lehrtage pro Woche',
        options: ['1','2','3','4','5'],
        text: ['Ich möchte nicht mehr als ', ' Tage pro Woche an der Hochschule unterrichten.'],
        showCourses: false
      },
      {
        type: 'SingleChoicePrio',				// einfachauswahl
        title: 'Maximale Anzahl aufeinanderfolgender Lehrtage',
        options: ['1','2','3','4','5'],
        text: ['Ich möchte pro Woche nicht mehr als ', ' Tage am Stück unterrichten.'],
        showCourses: false
      },
      {
        type: 'FreeTextInput',					// einfachauswahl
        title: 'Weitere Sonderwünsche - wenn dringend notwendig',
        text: 'Ich hätte gerne noch: ',
        showCourses: false
      }
    ];
  });

  angular.module("zhang-app").directive('priority', function($rootScope) {
    return function(scope, element, attrs) {
      // console.log(element, attrs.priority, scope.prio);

      scope.prio.dayOne = [ "day1", "time1" ];
      scope.prio.dayTwo = [ "day2", "time2" ];

      // scope.prio.ExcludeDayCombinationPrio = [ {
      //   dayOne: [
      //     "day", "time"
      //   ],
      //   dayTwo: [
      //     "day", "time"
      //   ] }
      // ];

      scope.prio.course = "Alle Kurse";
      // scope.prio

      scope.change = function(selected) {
        scope.prio.option = selected;
      }
    }
  });
})();

$(document).ready(function() {

    $('#course-list-next').click(function(){
      $('.course-selector-wrapper').fadeOut()
    })
    $('#add-course').click(function(){
      $('.course-selector-wrapper').fadeIn()
    })

    $('.menu-trigger').click(function() {
      $(".menu").fadeToggle();
    });

    $(window).resize(function() {
      $(".menu").removeAttr('style');
    });

});
