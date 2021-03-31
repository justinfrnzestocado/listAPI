package com.pragmanila.listAPI.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//API LAYER
@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    //Used the method inside the EmployeeService.java

    private final EmployeeService employeeService;

    //passed inside the EmployeeServices
    @Autowired //dependency injection annotation and connection to employeeService
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Get or used method inside EmployeeService/BusinessLogic
    @GetMapping
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }

    //Post
    @PostMapping
    public void registerNewEmployee(@RequestBody Employee employee)
    {
        employeeService.addNewEmployee(employee);
    }

    //Delete
    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(
            @PathVariable("employeeId") Long employeeId)
    {
        employeeService.deleteEmployee(employeeId);
    }

    //Put
    @PutMapping(path = "{employeeId}")
    public void updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String pnm
            )
            {
                employeeService.updateEmployee(employeeId, name, email, pnm);
            }

}
