package employeemgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employeemgmt.entity.Employee;
import employeemgmt.exception.EmployeeNotFoundException;
import employeemgmt.exception.NoRecordFoundException;
import employeemgmt.repository.EmpRepository;

@Service
public class EmpService implements IEmpService {

	@Autowired
	private EmpRepository repo;

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(Integer eid) {
		Optional<Employee> employee=repo.findById(eid);
		if(employee!=null) {
			return employee;
		}
		else {
			throw new EmployeeNotFoundException("Employee not found with id"+eid);
		}
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		return repo.save(employee);
	}

	@Override
	public void delete(Integer id) {
		
		repo.deleteById(id);
	}



	
	
	
}
