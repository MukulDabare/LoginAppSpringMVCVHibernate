package com.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoi.HomeDaoI;
import com.model.Student;
import com.servicei.HomeServiceI;
@Service
public class HomeServiceImpl implements HomeServiceI{

	  @Autowired
		HomeDaoI hdi;
	
	@Override
	public void saveStudent(Student s) {
		
		System.out.println("sending Object from HomeServiceImpl to HomeDaoI ");
		hdi.saveStudent(s);
		System.out.println(s.getName());
	}

	@Override
	public List<Student> getStudent() {
		
		return hdi.getStudent();
	}

	@Override
	public void deleteStudent(int rollno) {
		
		hdi.deleteStudent(rollno);
	}

	@Override
	public Student editStudent(int rollno) {
		
		return hdi.editStudent(rollno);
	}

	@Override
	public void updateStudent(Student s) {
		
		hdi.updateStudent(s);
	}

	@Override
	public List<Student> logincheck(String username, String password) {
		List<Student> list = hdi.logincheck(username, password);
		return list;
	}

}
