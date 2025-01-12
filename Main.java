package com.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Department;
import com.entity.Employee;

public class Main {

	 public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Department.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction ts = ss.beginTransaction();
		
		
		Employee e1 = new Employee();
		e1.setEmp_id(12345876);
		e1.setEmp_name("Viraj");
		ss.persist(e1);
		
		Employee e2 = new Employee();
		e2.setEmp_id(76543245);
		e2.setEmp_name("sahil");
		ss.persist(e2);
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		
		Department d = new Department();
		d.setD_id(1124);
    	d.setD_name("Database Engineer");
    	
    	e1.setDept(d);
    	e2.setDept(d);
    	
    	d.setEmp(list);
		ss.persist(d);
		
		ts.commit();
		ss.close();
	}
}
