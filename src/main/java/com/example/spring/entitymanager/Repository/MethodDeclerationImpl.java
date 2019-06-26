package com.example.spring.entitymanager.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.stereotype.Service;

import com.example.spring.entitymanager.entities.CompletedProjectList;
import com.example.spring.entitymanager.entities.Course;
import com.example.spring.entitymanager.entities.Department;
import com.example.spring.entitymanager.entities.Employee;

@Service
public class MethodDeclerationImpl implements MethodDeclarations{

	@PersistenceContext
    private EntityManager em;

    public List<Course> nameByCourse() {            
    	CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> variableRoot = query.from(Course.class);
        query.select(variableRoot);

        return em.createQuery(query).getResultList();
    }

	@Override
	public List<Course> FindByOpps() {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Course> criteria = builder.createQuery(Course.class);
		Root<Course> root = criteria.from(Course.class);
		root.getAlias();
		System.out.println("Alies" + root.getAlias());
		criteria.where(
		    builder.equal(root.get("Type"), "opps"),
		    builder.notEqual(root.get("Type"), ""));
		 
		List<Course> topics = em.createQuery(criteria).getResultList();
		for (Course course : topics) {
			System.out.println("topics === "+ course.getName());
		}
		System.out.println("topics === "+ topics.size());
		return topics;
	}
	
	@Override
	public List<CompletedProjectList> completedProject() {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<CompletedProjectList> criteria = builder.createQuery(CompletedProjectList.class);
		Root<CompletedProjectList> root = criteria.from(CompletedProjectList.class);
		root.getAlias();
		System.out.println("Alies" + root.getAlias());
		criteria.where(builder.equal(root.get("project_status"), "Completed"), builder.notEqual(root.get("lat"), ""));

		List<CompletedProjectList> topics = em.createQuery(criteria).getResultList();
		for (CompletedProjectList course : topics) {
			System.out.println("CompletedProject === " + course.getProject_management_consultant());
			System.out.println("CompletedProject === " + course.getPID());
		}
		System.out.println("CompletedProject Size === " + topics.size());
		return topics;
	}

	@Override
	public List<Employee> getEmployeeDetails() {
		// TODO Auto-generated method stub
		
		CriteriaBuilder builder= em.getCriteriaBuilder();
		CriteriaQuery<Employee> crtiteria_query= builder.createQuery(Employee.class);
		Root<Employee> root=	crtiteria_query.from(Employee.class);
		root.fetch("department");
		//crtiteria_query.where((root.get("emp_id"), 1);
		List<Employee> emp_list = em.createQuery(crtiteria_query).getResultList();
		for (Employee employee : emp_list) {
			System.out.println("Employee === " + employee.getDesignation());
			System.out.println("Employee === " + employee.getName());
			
			Department depart= employee.getDepartment();
			
			System.out.println("depart === " + depart.getName());
			System.out.println("depart ID === " + depart.getId());
		}
		
		
		return emp_list;
	}

	@Override
	public List<Object[]> getEmployeeDepartmentJoinDetails() {
		// TODO Auto-generated method stub
		CriteriaBuilder builder= em.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		Root<Employee> rootEmp = criteriaQuery.from(Employee.class);
		Root<Department> rootDept = criteriaQuery.from(Department.class);
		
		criteriaQuery.multiselect(rootEmp,rootDept);
		criteriaQuery.where(builder.equal(rootEmp.get("department"), rootDept.get("id")));
		
		Query<Object[]> query = (Query<Object[]>) em.createQuery(criteriaQuery);
		
		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {
			//Here we are getting data employee into 0th position
			Employee employee=(Employee)objects[0];
			System.out.println(employee.getId()+"\t"+employee.getName());
			//Here we are getting data department into 1st position
			Department department=(Department)objects[1];
			
			System.out.println(department.getId()+"\t"+department.getName());
		}
		return resultList;
	}

}

//CriteriaBuilder cb = em.getCriteriaBuilder();
//
//CriteriaQuery<Course> query = cb.createQuery(Course.class);
//
//Root<Course> root = query.from(Course.class);
//
//query = query.select(root).distinct(true)
//      .where(cb.equal(root.get("Type"), "opps"));
//
//query = query.orderBy(cb.asc(root.get("name")));
//return em.createQuery(query).getResultList();

