package employeemgmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import employeemgmt.entity.Employee;
import employeemgmt.repository.EmpRepository;
import employeemgmt.service.EmpService;

@SpringBootTest
class EmployeeMgmtSystemApplicationTests {
	
	@Autowired
	private EmpService service;
	
	@MockBean
	private EmpRepository repo;
	
	@Test
	public void getAllEmployeeTest(){
	    when(repo.findAll()).thenReturn(Stream
	    .of(new Employee(1,"John","100000")).collect(Collectors.toList()));
	    assertEquals(1,service.getAllEmployees().size());
	}
	
	@Test
	public void getByIdTest() {
	int id=1;
	when(repo.findById(id))
    .thenReturn(Optional.empty());
	}
	
	@Test
	public void saveEmpTest() {
		Employee employee=new Employee(2,"Den","300000");
		when(repo.save(employee)).thenReturn(employee);
		assertEquals(employee,service.addEmployee(employee));
	}
	
	@Test
	public void deleteTest() {
		Employee employee=new Employee(2,"Den","300000");
		service.delete(2);
		//verify(repo,times(1)).delete(employee);
	}
}
