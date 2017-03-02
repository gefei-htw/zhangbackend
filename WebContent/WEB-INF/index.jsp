<!DOCTYPE html>
<html ng-app="zhang-app">
  <head>
    <meta charset="utf-8">
    <title>Lehrprofil</title>

    <!-- styles -->
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/style2.css">
    <!-- end of styles -->




    <!-- libs -->
  <script src="js/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
  <script type="text/javascript" src="js/courses.js"></script>
	<script type="text/javascript" src="js/calendar.js"></script>
  <script src="js/bootstrap.js"></script>
  <script type="text/javascript" src="js/priorities.js"></script>

	<!-- libs end -->

  </script>
  </head>
  <body>

    <div class="course-selector-wrapper">
      <div class="course-selector" ng-controller="courseController">
        <span>Bitte ihre Lehrveranstaltungen auswählen</span>
        <div class="course-list">
          <input type="search" id="course-list-search" ng-model="search" placeholder="Durchsuche Kurse">
          <div class="course-scroll">
            <div class="course" ng-repeat="course in list | filter:search">
              <input type="checkbox" ng-model="course.selected" ng-change="clickfick($event)">
              <span>{{course.id}}</span> - {{course.kurzname}}
            </div>
          </div>
        </div>

        <div class="selected-courses">
          <div class="selected-course" ng-repeat="course in list | filter: {selected: 'true'}">
            <span>{{course.id}}  </span><span ng-click="selectVal($event)">{{course.kurzname}}</span>
          </div>
        </div>

        <button type="button" name="button" id="course-list-next">Weiter</button>

      </div>
    </div>

    <header class="group">
      <div class="container">
				<div class="navbar-header">
					<button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a href="/" class="navbar-brand">HTW FB4 Lehreinsatzplanung</a>
				</div>
				<nav class="collapse navbar-collapse" role="navigation">
					<ul class="nav navbar-nav pull-right">
            <li>
							<a href="#sec" id="add-course">Kurse hinzufügen/entfernen</a>
						</li>
					</ul>
				</nav>
			</div>
	</header>
  <div class="row">
	<div class="main group">

		<div class="calendar group col-md-6">
			<h2>Bevorzugte Belegungszeiten</h2>
      <p>Bitte geben Sie hier ihre bevorzugten Belegungszeiten an. Sie können durch wiederholtes Anklicken der Kreise deren Farbe ändern, und so ihre Belegungswünsche abbilden.</p>
			<div class="option-choice group">
				<a href="#" class="preferred" prio="3">Bevorzugte Wahl</a>
				<a href="#" class="alternative" prio="2">Alternative Wahl</a><br>
        <a href="#" class="impossible" prio="1">Grundsätzlich möglich</a>
        <a href="#" class="no-pref-choice" prio="0">Nicht möglich</a>
			</div>
			<div class="calendar-body group">
				<div class="first-calendar-row">
					<span class="week-day">MO</span>
					<span class="week-day">DI</span>
					<span class="week-day">MI</span>
					<span class="week-day">DO</span>
					<span class="week-day">FR</span>
				</div>
				<div class="calendar-row">
					<span class="lecture-time">08:00 - 09:30</span>
					<div class="calendar-input" prio="1"></div>
					<div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
				</div>
				<div class="calendar-row">
					<span class="lecture-time">09:45 - 11:15</span>
					<div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
				</div>
				<div class="calendar-row">
					<span class="lecture-time">12:15 - 13:45</span>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
				</div>
				<div class="calendar-row">
					<span class="lecture-time">14:00 - 15:30</span>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
				</div>
				<div class="calendar-row">
					<span class="lecture-time">15:45 - 17:15</span>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
				</div>
				<div class="calendar-row">
					<span class="lecture-time">17:30 - 19:00</span>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
			        <div class="calendar-input" prio="1"></div>
				</div>
			</div>
		</div>
    <!-- div class="wishes-section group col-md-6" ng-controller="prioController">
      <h2>Sonderwünsche</h2>
      <br>
      <p>Bitte geben Sie hier gegebenenfalls spezielle Einschränkungen oder Sonderwünsche hinsichtlich Ihrer Verfügbarkeiten an. Ihre Auswahl im Belegungsplan wird entsprechend dieser Vorgaben angepasst. Um eine Einschränkung oder einen Sonderwunsch wieder zu entfernen, können Sie diese über den x-Button löschen. Als Grundlage zum Erstellen des Stundenplanes wird der Belegungsplan, sowie ggf. die hier definierten Einschränkungen und Sonderwünsche herangezogen.</p>
      <div class="priority-select-list">
        <div class="priority-select-list-entry" ng-repeat="option in possiblePriorities track by option.id" data-id="{{option.id}}" ng-click="selectPriority($event)" ng-class="option.jo_class">
          <div class="title">
            {{option.label}}
          </div>
        </div>
        <a id="priorities-submit-button" href="https://goo.gl/forms/qJApYR1M71WNR6nh1">Speichern und weiter zur Umfrage</a>
      </div>

      <div class="selected-priorities">
        <ul id="priority-list">

        </ul>
      </div>
    </div -->

    <div class="wishes-section group col-md-6" ng-controller="prioController">
      <h2>Sonderwünsche</h2>
      <br>
      <p>Bitte geben Sie hier gegebenenfalls spezielle Einschränkungen oder Sonderwünsche hinsichtlich Ihrer Verfügbarkeiten an. Ihre Auswahl im Belegungsplan wird entsprechend dieser Vorgaben angepasst. Um eine Einschränkung oder einen Sonderwunsch wieder zu entfernen, können Sie diese über den x-Button löschen. Als Grundlage zum Erstellen des Stundenplanes wird der Belegungsplan, sowie ggf. die hier definierten Einschränkungen und Sonderwünsche herangezogen.</p>
      <div class="priority-select-list">
        <div class="priority-select-list-entry" ng-repeat="option in possiblePriorities" ng-click="selectPrio($index, option)">
          <div class="title">
            {{option.title}}
          </div>
        </div>
        <a id="priorities-submit-button">Speichern</a>
      </div>

      <div class="selected-priorities">
        <ul id="priority-list" ng-repeat="prio in selectedPriorities track by $index">
          <li class="priority-entry">
            <div class="priority-label" ng-click="prio.hideContent ? prio.hideContent=false : prio.hideContent=true">{{prio.title}}</div>
            <div class="priority-delete" ng-click="removeEntry($index, prio)">x</div>
            <div class="priority-conent" ng-hide="prio.hideContent">
              <div ng-if="prio.type == 'SingleChoicePrio'" class="somecontent">
                <p class="priotext">{{prio.text[0]}}</p>
                <select class="someselectclass">
                  <option ng-repeat="option in prio.options" value="$index">{{option}}</option>
                </select>
                <p class="priotext">{{prio.text[1]}}</p>
              </div>
              <div ng-if="prio.type == 'SimplePrio'" class="somecontent">
                <p class="priotext">{{prio.text}}</p>
              </div>
              <div ng-if="prio.type == 'ExcludeDayCombinationPrio' && prio.text.length <= 3" class="somecontent">
                <p class="priotext">
                  {{prio.text[0]}}
                </p>
                <select name="day">
                    <option>Ersten Tag wählen</option>
                    <option value="montag">Montag</option>
                    <option value="dienstag">Dienstag</option>
                    <option value="mittwoch">Mittwoch</option>
                    <option value="donnerstag">Donnerstag</option>
                    <option value="freitag">Freitag</option>
                </select>
                <p class="priotext">
                  {{prio.text[1]}}
                </p>
                <select name="time">
                    <option>Zweiten Tag wählen</option>
                    <option value="montag">Montag</option>
                    <option value="dienstag">Dienstag</option>
                    <option value="mittwoch">Mittwoch</option>
                    <option value="donnerstag">Donnerstag</option>
                    <option value="freitag">Freitag</option>
                </select>
                <p class="priotext">
                  {{prio.text[2]}}
                </p>
              </div>
              <div ng-if="prio.type == 'ExcludeDayCombinationPrio' && prio.text.length > 3" class="somecontent">
                <p class="priotext">
                  {{prio.text[0]}}
                </p>
                <select>
                    <option>Ersten Tag wählen</option>
                    <option value="montag">Montag</option>
                    <option value="dienstag">Dienstag</option>
                    <option value="mittwoch">Mittwoch</option>
                    <option value="donnerstag">Donnerstag</option>
                    <option value="freitag">Freitag</option>
                </select>
                <p class="priotext">
                  {{prio.text[1]}}
                </p>
                <select>
                    <option>Uhrzeit wählen</option>
                    <option value="0">08:00-09:30</option>
                    <option value="1">09:45-11:15</option>
                    <option value="2">12:15-13:45</option>
                    <option value="3">14:00-15:30</option>
                    <option value="4">15:45-17:15</option>
                    <option value="5">17:30-19:00</option>
                    <option value="6">19:15-20:45</option>
                </select>
                <p class="priotext">
                  {{prio.text[2]}}
                </p>
                <select>
                    <option>Zweiten Tag wählen</option>
                    <option value="montag">Montag</option>
                    <option value="dienstag">Dienstag</option>
                    <option value="mittwoch">Mittwoch</option>
                    <option value="donnerstag">Donnerstag</option>
                    <option value="freitag">Freitag</option>
                </select>
                <p class="priotext">
                  {{prio.text[3]}}
                </p>
                <select>
                    <option>Uhrzeit wählen</option>
                    <option value="0">08:00-09:30</option>
                    <option value="1">09:45-11:15</option>
                    <option value="2">12:15-13:45</option>
                    <option value="3">14:00-15:30</option>
                    <option value="4">15:45-17:15</option>
                    <option value="5">17:30-19:00</option>
                    <option value="6">19:15-20:45</option>
                </select>
                <p class="priotext">
                  {{prio.text[4]}}
                </p>
              </div>
              <div ng-if="prio.type == 'FreeTextInput'" class="somecontent">
                <p class="priotext">
                  {{prio.text}}
                </p>
                <textarea id="freeTextWish" name="freeTextWish" cols="35" rows="4"></textarea>
              </div>
              <div class="prio-course-select" ng-show="prio.showCourses">
                <select>
                  <option value="-1">Alle Kurse</option>
                  <option ng-repeat="course in $root.courseList" value="{{course.id}}">{{course.kurzname}}</option>
                </select>
              </div>
            </div>

          </li>
        </ul>
      </div>
    </div>


    <div id="templates" style="display: none;">
      <div id="template1">
        <p class="priotext">
        </p>
        <select name="day">
            <option>Ersten Tag wählen</option>
            <option value="montag">Montag</option>
            <option value="dienstag">Dienstag</option>
            <option value="mittwoch">Mittwoch</option>
            <option value="donnerstag">Donnerstag</option>
            <option value="freitag">Freitag</option>
        </select>
        <p class="priotext"></p>
        <select name="time">
            <option>Zweiten Tag wählen</option>
            <option value="montag">Montag</option>
            <option value="dienstag">Dienstag</option>
            <option value="mittwoch">Mittwoch</option>
            <option value="donnerstag">Donnerstag</option>
            <option value="freitag">Freitag</option>
        </select>
        <p class="priotext"></p>
      </div>
    </div>
  </div>
</div>
	</body>
</html>
