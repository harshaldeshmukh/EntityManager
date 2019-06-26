package com.example.spring.entitymanager.Repository;

import java.util.List;

import com.example.spring.entitymanager.entities.CompletedProjectList;
import com.example.spring.entitymanager.entities.Course;
import com.example.spring.entitymanager.entities.Employee;

public interface MethodDeclarations {
	
 public	List<Course> nameByCourse() ;
 
 public	List<Course> FindByOpps() ;
		
 public List<CompletedProjectList> completedProject();
 
 public List<Employee> getEmployeeDetails();
 
 public List<Object[]> getEmployeeDepartmentJoinDetails();

}
