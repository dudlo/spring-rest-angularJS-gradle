## Sample project using Spring MVC, Spring REST, AngularJS, pure Java (no XML) configuration, Gradle, running in STS

This is a small prototype of a project that uses:

* Spring MVC (tested with Spring 4.1.1.RELEASE)
* AngularJS (tested with 1.2.25)
* Java-based configuration (no XML config files)
* Gradle (tested with 2.0)
* loads into STS (tested with 3.6.2)
* runs inside embedded TC server in STS (tested with STS 3.0 using tc Server 8.0.9)
* runs on Tomcat (tested with 8.0.11)
* Java (tested with Java 8)

The goal was to create minimal set of files that could be used to start a dynamic web project in STS. This is almost like an empty archetype to get started with Spring MVC, AngularJS, REST using Gradle in STS.

This project builds on https://github.com/dudlo/spring-mvc-noxml-gradle by adding AngularJS, REST, and some minimal (primitive) application logic. 

### How to load and run the project

Detailed load instructions from https://github.com/dudlo/spring-mvc-noxml-gradle/blob/master/README.md#how-to-load-and-run-the-project apply here.

### Notables

* The MyRestController has decent API but primitive/simplistic implementation. That's by design - in real app this class should be just a distribution facade to some repository. The implementation is also problematic (for example, changing id means adding a clone...). Again, the focus is on mechanics, not functionality.
* Note the difference between MyViewController and MyRestController. The first one is part of SpringMVC machinery; the second one is to support AJAX calls from AngularJS application. It's good to separate them as MyRestController could be used by some other client.
* I wanted to demonstrate how to use real objects (Employee) to pass values. For example, editedEmployee is not an id; it is an instance of Employee that is being edited and passed to saveEmployee() in controllers.js
* The two-way binding may be misleading. For example, as the editedEmployee is being edited, the change immediately reflects in the table of all employees. However, that change is not valid until posted to the server - so it is misleading. A better solution would be to notify the user if he forgot to press the Save button.
* myhello.jsp could/should be just a plain HTML file. By keeping it a JSP we have an option to add JSP features but we should not mix Angular UI with JSPs unless we get pushed to a corner. 

#### Holes and left to do items:

* add webjars for dependency management of AngularJS and Bootrstrap files. This would be an alternative to full client build using Bower.
* fix Employee in controller.js. I did not know how to instantiate Employee instance so I used just object literal in addEmployee() in controllers.js
* use angular-resource.js to treat the REST calls as a resource (not just a bunch of $http service calls). Add exception handling in the process (as of right now this does only happy path with no indication when error happens)
* verify/validate directory structure for .js, .css, .html, .jsp files. Is the current one following the conventions?
* add Bootstrap for better-looking UI 
* add tests