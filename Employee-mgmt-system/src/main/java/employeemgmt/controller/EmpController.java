package employeemgmt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import employeemgmt.entity.Employee;
import employeemgmt.exception.EmployeeNotFoundException;
import employeemgmt.service.EmpService;

@RestController
@RequestMapping(value="/employee")
public class EmpController {

	@Autowired
	public EmpService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll(){
		List<Employee> getAllCustomers=service.getAllEmployees();
		return new ResponseEntity<>(getAllCustomers,HttpStatus.OK);
	}
	
	@GetMapping("/{eid}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable int eid) throws EmployeeNotFoundException
	{
		Optional<Employee> employee=service.getEmployee(eid);
			return new ResponseEntity <Optional<Employee>>(employee,HttpStatus.OK);
	}
		
	
	@PostMapping("/save")
	public ResponseEntity<Employee> save( @RequestBody Employee employee)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addEmployee(employee));
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		 service.delete(id);
	}
	
	
}
