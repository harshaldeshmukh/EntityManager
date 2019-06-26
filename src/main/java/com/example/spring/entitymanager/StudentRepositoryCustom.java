package com.example.spring.entitymanager;

import java.util.List;

public interface StudentRepositoryCustom {
	
 public	List<Course> nameByCourse() ;
 
 public	List<Course> FindByOpps() ;
		
 public List<CompletedProjectList> completedProject();
 
 public List<Employee> getEmployeeDetails();
 
 public List<Object[]> getEmployeeDepartmentJoinDetails();

}
