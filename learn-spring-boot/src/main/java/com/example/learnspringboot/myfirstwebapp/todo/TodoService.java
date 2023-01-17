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
		//todos.add(new Todo(++todosCount, "in28minutes", "learn cloud", LocalDate.now().plusYears(3), LocalTime.now(), false));
		todos.add(new Todo(++todosCount, "in28minutes", "learn AWS 1",   LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "in28minutes", "learn java 222",  LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "in28minutes", "learn cloud 3", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String username)
	{
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetdate,LocalTime targettime,boolean done) {
		Todo todo=new Todo(++todosCount,username, description, targetdate,  done);
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
