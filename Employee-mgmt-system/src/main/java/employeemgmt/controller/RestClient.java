//package employeemgmt.controller;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import employeemgmt.entity.Employee;
//
//public class RestClient {
//
//	private static final String GET_ALL="http://localhost:8090/employee/getAll";
//	private static final String GET_By_ID="http://localhost:8090/employee/{eid}";
//	private static final String SAVE="http://localhost:8090/employee/save";
//	private static final String DELETE="http://localhost:8090/employee/delete/{id}";
//	
//	static RestTemplate restTemp=new RestTemplate();//restTemp class object
//	public static void main(String args[]) {
//		callGetAll();
//		getById();
//		saveEmp();
//		deleteEmp();
//			}
//	
//	private static void callGetAll() {
//		HttpHeaders headers=new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));//client accept json from rest-api
//		HttpEntity<String> entity=new HttpEntity<> ("parameters",headers);//pass multi-value params
//		
//	ResponseEntity<String> result=restTemp.exchange(GET_ALL,HttpMethod.GET,entity,String.class);
//	System.out.println(result);
//	}
//	
//	private static void getById() {
//		Map<String,Integer> param=new HashMap<>();
//		param.put("id",1);
//		
//	Employee employee=restTemp.getForObject(GET_By_ID,Employee.class,param);
//	System.out.println(employee.getId());
//	System.out.println(employee.getName());
//	System.out.println(employee.getSalary());
//	}
//	
//	
//	private static void saveEmp() {
//		Employee emp=new Employee(1,"John","120000");
//	ResponseEntity<Employee> save=restTemp.postForEntity(SAVE, emp, Employee.class);
//	System.out.println(save);
//	}
//	
//	private static void deleteEmp() {
//		Map<String,Integer> param=new HashMap<>();
//		param.put("id",1);
//		restTemp.delete(DELETE,param);
//	}
//
//}
