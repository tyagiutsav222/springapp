package com.example.learnspringboot.myfirstwebapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses()
	{
		return Arrays.asList(
		new Course(1, "springboot ",  "in28Minutes" ),
		new Course(2, "java ",  "in28Minutes" ),
		new Course(3, "acd ",  "in28Minutes" ),
		new Course(4, "yyy ",  "in28Minutes" ),
		new Course(5, "bbb ",  "in28Minutes" )
		
		);
	}
	@RequestMapping("/course")
	public List<Course> AllCourses()
	{
		return Arrays.asList(
		new Course(1, "springboot ",  "Minutes" ),
		new Course(2, "java ",  "Minutes" )
		
		
		);
	}
}
