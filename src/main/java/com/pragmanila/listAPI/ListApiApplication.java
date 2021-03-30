package com.pragmanila.listAPI;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController
//@RequestMapping(path = "api/v1/employee")
public class ListApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListApiApplication.class, args);
	}

//	@GetMapping
//	public List<Employee> getEmployees()
//	{
//		return List.of(
//				new Employee(
//						1L,
//						"Justin Franz",
//						"justin.estocado@pragmanila.com",
//						"09076415933",
//						LocalDate.of(1998, Month.JUNE, 11),
//						22
//				)
//		);
//	}
}
