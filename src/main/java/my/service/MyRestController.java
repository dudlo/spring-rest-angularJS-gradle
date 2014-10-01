package my.service;

import java.util.Collection;
import java.util.HashMap;

import my.domain.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Very simple REST controller. It uses GET, POST, CREATE, PUT, and DELETE methods. 
 *  
 * This controller is not (directly) involved in Spring MVC machinery. It means that it does not 
 * populate data and return view or model objects (in Spring MVC sense). However, it _is_ used 
 * by the client Javascript code to populate the values when the AngularJS code makes AJAX calls
 * to retrieve or update values. So it is used by the GUI client code but only as a strictly 
 * "data service" component. 
 *
 * Lifted from http://java.dzone.com/articles/spring-rest-controller (which is itself inspired by 
 * Spring's samples).
 * 
 */
@RestController
@RequestMapping("/rest/employees")
public class MyRestController {

   private static HashMap<String, Employee> employees = new HashMap<String, Employee>(); // hacked up hardwired global 'repository'

   public MyRestController() {
      employees.put("first", new Employee("first", "Jim Beam", "plumber"));
      employees.put("second", new Employee("second", "Johnny", "janitor"));
   }

   @RequestMapping(method = RequestMethod.POST)
   public Employee create(@RequestBody @Validated Employee Employee) {
      return employees.put(Employee.getId(), Employee);
   }

   @RequestMapping(method = RequestMethod.GET)
   public Collection<Employee> list() {
      return employees.values();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Employee get(@PathVariable("id") String id) {
      return employees.get(id);
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   public Employee update(@PathVariable("id") String id,
         @RequestBody @Validated Employee Employee) {
      return employees.put(Employee.getId(), Employee);
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
      employees.remove(id);
      return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
   }
}
