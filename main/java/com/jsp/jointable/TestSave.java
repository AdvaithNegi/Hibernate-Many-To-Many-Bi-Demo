package com.jsp.jointable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("advaith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		List<Teacher> al = new ArrayList<Teacher>();
		List<Job> al1 = new ArrayList<Job>();

		Teacher teacher1 = new Teacher();
		teacher1.setName("Sejal");
		teacher1.setEmail("sejal@mail.com");

		Teacher teacher2 = new Teacher();
		teacher2.setName("Varun");
		teacher2.setEmail("varun@mail.com");

		al.add(teacher1);
		al.add(teacher2);

		Job job1 = new Job();
		job1.setName("Software Engineer");
		job1.setSalary(50000);

		Job job2 = new Job();
		job2.setName("Database Engineer");
		job2.setSalary(70000);

		al1.add(job1);
		al1.add(job2);

		teacher1.setJobs(al1);
		teacher2.setJobs(al1);

		job1.setTeachers(al);
		job2.setTeachers(al);

		entityTransaction.begin();
		entityManager.persist(teacher1);
		entityManager.persist(teacher2);
		entityTransaction.commit();

	}
}
