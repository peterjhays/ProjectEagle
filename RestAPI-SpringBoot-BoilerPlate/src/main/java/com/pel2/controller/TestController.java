/**
 * 
 */
package com.pel2.controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pel2.dto.Employee;
import com.pel2.service.TestService;
import java.text.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;


/**
 * @author mbaransln
 * Below is the test Controller to create other controller classes based on your requirements.
 *
 */
@RestController
@CrossOrigin
@RequestMapping( value = "/employee")
public class TestController {	
	
    //Service class implements the Business logic and interact with other services/DAO based on the requirement.
    @Autowired
    TestService testService;
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Employee> getEmployees(){
        return testService.getEmployees();
    }

    @RequestMapping(value = "/details" , method = RequestMethod.POST)
    public Employee getEmployee(@RequestBody String id){
        Employee responseObj = testService.getEmployee(id);
        System.out.println("TestController.getEmployee()"+responseObj.toString());
        return responseObj;
    }

    @PostMapping(value = "/emp")
    public int addEmployee(@RequestBody Employee emp) throws SQLException, ParseException {
        return testService.saveEmployee(emp);
    }
    
   @PostMapping(value = "/update") 
   public boolean updateEmployee(@RequestBody Employee emp) throws SQLException, ParseException {
       return testService.updateEmployee(emp);
   } 
   
   @RequestMapping(value = "/delete" , method = RequestMethod.POST)
   public boolean delEmployee(@RequestBody String id) throws SQLException {
       //Parse id string.
       id = id.replaceAll("%22", "").replaceAll("=", "");
       return testService.deleteEmployee(id);
   }

}
