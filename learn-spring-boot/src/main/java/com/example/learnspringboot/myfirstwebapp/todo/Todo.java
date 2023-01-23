package com.example.learnspringboot.myfirstwebapp.todo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="TodoTable")
public class Todo {
	
	public Todo()
	{}
	
	public Todo(int id, String username, String description, LocalDate targetdate,  boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetdate;
		/* this.targettime = targettime; */
		this.done = done;
	}
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	@Size(min=5, message="Enter atleast 10characters")
	private String description;
	@FutureOrPresent(message="date must be less than today")  
	private LocalDate targetDate;
	/* private LocalTime targettime; */
	private boolean done;
	

	
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetdate() {
		return targetDate;
	}
	public void setTargetdate(LocalDate targetdate) {
		this.targetDate = targetdate;
	}

	/*
	 * public LocalTime getTargettime() { return targettime; }
	 * 
	 * public void setTargettime(LocalTime targettime) { this.targettime =
	 * targettime; }
	 */	
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	@Override
	public String toString() {
		return "Todo [id= " + id + ", username= " + username + ", description= " + description + ", targetdate= "
				+ targetDate + ", done= " + done + "]";
	}

}
