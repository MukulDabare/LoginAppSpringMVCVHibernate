package com.daoi;

import java.util.List;

import com.model.Student;

public interface HomeDaoI {
	
	public void saveStudent(Student s);
	public List<Student> getStudent();
	public void deleteStudent(int rollno);
	public Student editStudent (int rollno);
	public void updateStudent(Student s);
	public List<Student> logincheck(String username, String password);

}
