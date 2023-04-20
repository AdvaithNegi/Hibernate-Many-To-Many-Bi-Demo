package com.jsp.student.course;

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

		List<Student> al = new ArrayList<Student>();
		List<Course> al1 = new ArrayList<Course>();

		Student student1 = new Student();
		student1.setName("Sejal");
		student1.setEmail("sejal@mail.com");

		Student student2 = new Student();
		student2.setName("Masoom");
		student2.setEmail("masoom@mail.com");

		Student student3 = new Student();
		student3.setName("Sharayu");
		student3.setEmail("sharayu@mail.com");

		Student student4 = new Student();
		student4.setName("Advaith");
		student4.setEmail("advaith@mail.com");

		al.add(student1);
		al.add(student2);
		al.add(student3);
		al.add(student4);

		Course course1 = new Course();
		course1.setName("SQL");
		course1.setDuration("2 Months");

		Course course2 = new Course();
		course2.setName("JAVA");
		course2.setDuration("3 Months");

		al1.add(course1);
		al1.add(course2);

		student1.setCourses(al1);
		student2.setCourses(al1);
		student3.setCourses(al1);
		student4.setCourses(al1);

		course1.setStudents(al);
		course2.setStudents(al);

		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityManager.persist(student4);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityTransaction.commit();

	}

}
