package com.pragmanila.listAPI.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//SERVICE LAYER/ BUSINESS LOGIC
@Service //annotation for Bean or Service Class
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //Get or Read
    public List<Employee> getEmployees()
    {
        return employeeRepository.findAll();
    }

    //Post
    public void addNewEmployee(Employee employee) {

        //Checks if email already taken or not
        Optional<Employee> employeeByEmail = employeeRepository.
                findEmployeeByEmail(employee.getEmail());
        if (employeeByEmail.isPresent())
        {
            throw new IllegalStateException("Email Taken");
        }
        employeeRepository.save(employee);
    }


    //Delete
    public void deleteEmployee(Long employeeId) {
       boolean exists = employeeRepository.existsById(employeeId);

       if (!exists)
       {
           throw new IllegalStateException(
                   "Employee with id " + employeeId + " does not exists!"
           );
       }
       employeeRepository.deleteById(employeeId);
    }

    //Put or Update
    @Transactional
    public void updateEmployee(Long employeeId,
                               String name,
                               String email,
                               String pnm,
                               LocalDate dob) {
    Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
            new IllegalStateException("Employee with id " + employeeId + " does not exists!")
    );
           if ( name != null && name.length() > 0 && !Objects.equals(employee.getName(), name))
           {
               employee.setName(name);
           }

           if ( email != null && email.length() > 0 && !Objects.equals(employee.getEmail(), email))
           {
               Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(email);
               if ( employeeOptional.isPresent())
               {
                   throw new IllegalStateException("Email Taken!");
               }
               employee.setEmail(email);
           }

           if ( pnm != null && pnm.length() > 0 && !Objects.equals(employee.getPnm(), pnm))
           {
               employee.setPnm(pnm);
           }

           if ( dob != null && !dob.equals(LocalDate.now()) && !Objects.equals(employee.getDob() ,dob))
           {
               employee.setDob(dob);
           }
    }
}
