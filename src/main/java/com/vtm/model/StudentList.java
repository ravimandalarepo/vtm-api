package com.vtm.model;

import java.util.List;

import com.im.model.student.entity.Student;

public class StudentList {
private List<Student> students;
private Integer totalStudents;

public Integer getTotalStudents() {
	return totalStudents;
}

public void setTotalStudents(Integer totalStudents) {
	this.totalStudents = totalStudents;
}

public List<Student> getStudents() {
	return students;
}

public void setStudents(List<Student> students) {
	this.students = students;
}
}
