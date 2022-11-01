package employeemgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import employeemgmt.entity.Employee;


@Service
public interface IEmpService {
	public List<Employee> getAllEmployees();
	
	public  Optional<Employee> getEmployee(Integer eid);

	public Employee addEmployee(Employee employee);

	public void delete(Integer id);
}
