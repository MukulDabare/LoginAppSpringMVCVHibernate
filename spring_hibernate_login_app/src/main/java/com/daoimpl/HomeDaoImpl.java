package com.daoimpl;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daoi.HomeDaoI;
import com.model.Student;
@Repository
public class HomeDaoImpl implements HomeDaoI {

   @Autowired
    SessionFactory sf;
    
	
	@Override
	public void saveStudent(Student s) {
		
	System.out.println("Saving Object from HomeDaoImpl");
		Session session = sf.openSession();
		session.save(s);
		session.beginTransaction().commit();
	}


	@Override
	public List<Student> getStudent() {
		Session session = sf.openSession();
		List<Student> list = session.createQuery("from Student",Student.class).getResultList();
		return list;
	}


	@Override
	public void deleteStudent(int rollno) {
	    Session session = sf.openSession();
	    Student student = session.get(Student.class, rollno);
	    session.delete(student);
	    session.beginTransaction().commit();
	  }


	@Override
	public Student editStudent(int rollno) {
		Session session = sf.openSession();
		Student s = session.get(Student.class, rollno);
		return s;
	}


	@Override
	public void updateStudent(Student s) {
		Session session = sf.openSession();
		session.saveOrUpdate(s);
		session.beginTransaction().commit();
	}


	@Override
	public List<Student> logincheck(String username, String password) {
		Session session = sf.openSession();
		System.out.println(username);
//		ProcedureCall call = session.createStoredProcedureCall("getSingleStudent");
//		call.registerStoredProcedureParameter("u", String.class, ParameterMode.IN);
//		call.setParameter("u", username);
//		call.registerStoredProcedureParameter("p", String.class, ParameterMode.IN);
//		call.setParameter("p", password);
//		 List list = call.getResultList();
//		System.out.println("In HDAO"+" "+list);
		
		String hql="from Student where username= :u and password=:p";
		Query<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("u", username);
		query.setParameter("p", password);
		List<Student> list = query.getResultList();
		return list;
	}
	
	

}
