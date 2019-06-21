package com.example.spring.entitymanager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.hibernate.Metamodel;
import org.springframework.stereotype.Service;

@Service
public class StudentRepositoryImpl implements StudentRepositoryCustom{

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
		System.out.println("topics === " + topics.size());
		return topics;
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

