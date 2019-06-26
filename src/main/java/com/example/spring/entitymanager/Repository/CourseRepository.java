package com.example.spring.entitymanager.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.entitymanager.entities.Course;

@Repository
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	
	public Course findById(Long i) {
		
		return em.find(Course.class, i);
		
	};
	
	
	public List<Course> criteria() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Course> q= cb.createQuery(Course.class);
		
		
		Root<Course> c= q.from(Course.class);
		
		
		q.select(c);
		
		System.out.println(" ***************************  " +  q.select(c).toString());
		
		Query query = em.createQuery(q);
		return query.getResultList();
		}

}
