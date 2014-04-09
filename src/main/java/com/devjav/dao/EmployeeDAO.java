/*
 * devjav [http://devjav.com]
 * Copyright (C) 2014-2014 Pham Thai Thinh
 * Contact:phamthaithinh@gmail.com
 * 
 */
package com.devjav.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.devjav.domain.Employee;

/**
 * 
 * @author Pham Thai Thinh
 * 
 */
@Repository
public class EmployeeDAO {
	@PersistenceContext
	private EntityManager em;

	public Employee insert(Employee emp) {
		em.persist(emp);
		return emp;
	}

	public Employee update(Employee emp) {
		em.merge(emp);
		return emp;
	}

	public List<Employee> listAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> emp=cq.from(Employee.class);
		TypedQuery<Employee> tq = em.createQuery(cq.select(emp));
		return tq.getResultList();
	}

}
