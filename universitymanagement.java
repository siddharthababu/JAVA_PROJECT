package com.codegnan.universtymanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class universitymanagement {
	
	private List<student> students;
	private List<professor> professors;
	private List<course> courses;
	
	public universitymanagement() {
		students=new ArrayList<>();
		professors=new ArrayList<>();
		courses=new ArrayList<>();
	}
	public void addStudent(String name) {
		students.add(new student(name));
	}
	
	public void addprofessor(String name) {
		professors.add(new professor(name));
	}
	
	public void addCourse(String title) {
		courses.add(new course(title));
	}
	
	public void enrollStudentInCourse(String studentName,String courseTitle) {
		student student=findStudentByName(studentName);
		course course=findCourseByTitle(courseTitle);
		if(student!=null && course!=null) {
			student.enrollInCourse(course);
		}else {
			System.out.println("Student or course Not Found");
		}
	}
	
	public void assignCourseToProffesor(String professorName,String courseTitle ) {
		professor professor=findProfessorByName(professorName);
		course course=findCourseByTitle(courseTitle);
		if(professor!=null && course!=null) {
			professor.assigncourse(course);
		}else {
			System.out.println("Professor or course not found");
		}
	}
	
	public void listStudents() {
		System.out.println("List of students in university: ");
		for(student student:students) {
			System.out.println(student);
		}
	}
	
	public void listProfessors() {
		System.out.println("Professors in University: ");
		for(professor professor:professors) {
			System.out.println(professor);
		}
	}

	public void listCourses() {
		System.out.println("Courses in University: ");
		for(course courses:courses) {
			System.out.println(courses);
		}
	}
	
	public void displayStudentCourses(String studentName) {
		student student=findStudentByName(studentName);
		if(student!=null) {
			System.out.println("Courses for Student : "+studentName+" : ");
			for(course course:student.getEnrolledCourses()) {
				System.out.println(course);
			}
		}else {
			System.out.println("Student Not Found : ");
		}
	}
	
	public void displayProfessorCourses(String professorName) {
		professor professor=findProfessorByName(professorName);
		if(professor!=null) {
			System.out.println("Courses assigned to professor "+professorName+" : ");
			for(course course:professor.getassignedCourses()) {
				System.out.println(course);
			}
			}else {
				System.out.println("Professor Not Found : ");
			}
			}
	
	private student findStudentByName(String name) {
		for(student student : students) {
			if(student.getName().equals(name)) {
				return student;
			}
		}return null;
	}
	private professor findProfessorByName(String name) {
		for(professor professor:professors) {
			if(professor.getName().equals(name)) {
				return professor;
			}
		}return null;
	}
	
	private course findCourseByTitle(String title) {
		for(course course:courses) {
			if(course.getTitle().equals(title)) {
				return course;
			}
		}return null;
	}
	public static void main(String[] args) {
		universitymanagement managment=new universitymanagement();
		
		Scanner scanner=new Scanner(System.in);
		boolean running=true;
		
		while(running) {
			System.out.println("\n University Managment System");
			System.out.println("1. Add Student");
			System.out.println("2. Add Professor");
			System.out.println("3. Add Course");
			System.out.println("4. Enroll Student in Course");
			System.out.println("5. Assign Course to professor");
			System.out.println("6. List Students");
			System.out.println("7.List Professors");
			System.out.println("8.List Courses");
			System.out.println("9. Display Student Courses");
			System.out.println("10. Display professor Courses");
			System.out.println("11.Exit");
			
			System.out.println("Choose an option");
			int choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 1:
				System.out.print("Enter Student Name: ");
				String studentName=scanner.nextLine();
				managment.addStudent(studentName);
				break;
			case 2:
				System.out.print("Enter professor name: ");
				String professorName=scanner.nextLine();
				managment.addprofessor(professorName);
				break;
			case 3:
				System.out.print("Enter course title: ");
				String coursetitle=scanner.nextLine();
				managment.addCourse(coursetitle);
				break;
			case 4:
				System.out.print("Enter student name: ");
				String enrollStudent=scanner.nextLine();
				System.out.print("Enter Course Title");
				String enrollCourse=scanner.nextLine();
				break;
			case 5:
				System.out.print("Enter professor name: ");
				String assignProfessor=scanner.nextLine();
				System.out.print("Enter Course Title");
				String assignCourse=scanner.nextLine();
				managment.assignCourseToProffesor(assignProfessor,assignCourse);
				break;
			case 6:
				managment.listStudents();
				break;
			case 7:
				managment.listProfessors();
				break;
			case 8:
				managment.listCourses();
				break;
			case 9:
				System.out.print("Enter student name: ");
				String dispalyStudent=scanner.nextLine();
				managment.displayStudentCourses(dispalyStudent);
				break;
			case 10:
				System.out.print("Enter professor name: ");
				String displayProfessor=scanner.nextLine();
				managment.displayProfessorCourses(displayProfessor);
				break;
			case 11:
				running=false;
				System.out.println("Exiting...");
				break;
				
				default:
					System.out.println("Invalid Choice.please enter a number b/w 1 to 11..");
					break;
			}
		}
scanner.close();
	}

}