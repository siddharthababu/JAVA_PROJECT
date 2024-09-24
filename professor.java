package com.codegnan.universtymanagement;

import java.util.ArrayList;
import java.util.List;

public class professor {
	private String name;
	private List<course> assignedCourses;//List to hold courses assigned to professor.
	
	public professor(String name) {
		this.name=name;
		this.assignedCourses=new ArrayList();//list of assigned courses as an empty list.
	}
	
	public String getName() {
		return name;
	}
	
	public void assigncourse(course course) {
		if(!assignedCourses.contains(course)) {
			assignedCourses.add(course);
		}
	}
	public List<course> getassignedCourses(){
		return assignedCourses;
	}
	public String toString() {
		return name;
	}
}