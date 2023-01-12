package com.example.learnspringboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	static
	{
		todos.add(new Todo(++todosCount, "in28minutes", "learn AWS",   LocalDate.now().plusYears(1), LocalTime.now(), false));
		todos.add(new Todo(++todosCount, "in28minutes", "learn java",  LocalDate.now().plusYears(2), LocalTime.now(), false));
		todos.add(new Todo(++todosCount, "in28minutes", "learn cloud", LocalDate.now().plusYears(3), LocalTime.now(), false));
	}
	
	public List<Todo> findByUsername(String username)
	{
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetdate,LocalTime targettime,boolean done) {
		Todo todo=new Todo(++todosCount,username, description, targetdate, targettime, done);
		todos.add(todo);
	}
	
	//delete todo by id
	
	public void deleteById(int id) {
		
		Predicate<? super Todo> predicate = todo ->todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = todo ->todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteById(todo.getId());
		todos.add(todo);
	}
}
