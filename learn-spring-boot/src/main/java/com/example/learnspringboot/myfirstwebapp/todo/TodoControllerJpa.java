package com.example.learnspringboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	
	
	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}

	private TodoService todoService;
	
	private TodoRepository todoRepository;
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) 
	{
		String username=getLoggedInUsername(model);
		
		
		
		List<Todo> todos= todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		return "ListTodos";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication =  
				SecurityContextHolder.getContext().getAuthentication();
				
		return authentication.getName();
	}

	/*
	 * @Id int id = 0;
	 */
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) 
	{	
		String username=getLoggedInUsername(model);
		
		Todo todo=new Todo(0, username,"", LocalDate.now().plusYears(1),true);
		
		model.put("todo", todo);
		
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodoPage( ModelMap model, @Valid Todo todo, BindingResult result) 
	{
		if(result.hasErrors())
		{
			return "todo";
		}
		
		
		String username=getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		//todoService.addTodo(username, todo.getDescription(), todo.getTargetdate(), null, false);
		return "redirect:list-todos";
	}
	
	//Delete Todo
	@RequestMapping(value="delete-todo")
	public String deleteTodo(@RequestParam int id) 
	{	
		//todoService.deleteById(id);
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	
	//update todo
	@RequestMapping(value="update-todo",  method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) 
	{
		
		
		//Todo todo=todoService.findById(id);
		Todo todo=todoRepository.findById(id).get();
	    model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",  method=RequestMethod.POST)
	public String updateTodo(@Valid Todo todo,ModelMap model,BindingResult result) 
	{
		if(result.hasErrors())
		{
			return "todo";
		}
		
		String username=getLoggedInUsername(model);
		
		todo.setUsername(username);
		
		//todoService.updateTodo(todo);
		todoRepository.save(todo);
	   
		return "redirect:list-todos";
	}
	

}
