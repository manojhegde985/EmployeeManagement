package employeemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import employeemgmt.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer>{

	//Employee findByEmpId(int eid);
}
