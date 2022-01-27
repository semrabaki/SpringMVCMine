package com.techproed.review;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class studentResultController {
	
//1.way:
	
//	@RequestMapping("addStudent")
//	public String addStudent1(@RequestParam("id") int id, @RequestParam("name") String name, Model m)
//	{
//		//First Object Creation Way
////		Student student= new Student();
////		student.setId(id);
////		student.setName(name);      //This is using constructor without paramters
//		
//		//Second Object Creation Way
//		
//		Student student= new Student(id,name); //making params dynamic bcz the user will enter them
//		m.addAttribute("studentObject",student);
//		return "studentResult";
//		
//	}
//	
	
//	//2.way
//	
//	@RequestMapping("addStudent")
//	public String addStudent2(@ModelAttribute Student student, Model m) {
//		m.addAttribute("studentObject",student);
//		
//		return "studentResult";
//	}
	
//	//3.way
//	
//	@RequestMapping("addStudent")
//	public String addStudent3(@ModelAttribute("studentObject") Student student) {
//		
//		return "studentResult";
//	}
//	
////	//How to get a specific field from the object, you need to use ModelAttribute
////	
//	@ModelAttribute
//	public void greetStudent(Model m, Student student)
//	{
//		m.addAttribute("greetStudent",student.getName());
//		
//	}

	
	//How to use POST method:
	//1.way
    /*to use post method:
     * 1)inside the methos paranthesis type methods=RequestMethos.POST
     * 2)then go to index.jsp file and add methos= "post" inside the form tag
     * 
     */
//	
//	@RequestMapping(value="addStudent", method=RequestMethod.POST)
//	public String addStudent3(@ModelAttribute("studentObject") Student student) {
//		
//		return "studentResult";
//	}
//	
//	@ModelAttribute   //How to get a specific field from the object, you need to use ModelAttribute
//	public void studentGreet(Model m, Student student)
//	{
//		m.addAttribute("greetStudent", student.getName());
//	}
	
			
			//2.way:
		/*
		 To use post methos:
		 1)Use @PostMApping ("addStudent") with action name from the form tag
		 2)then go to index.jsp and add method="post" inside the from tag
		 */
	
//		@PostMapping("addStudent")
//		public String addStudent3(@ModelAttribute("studentObject") Student student) {
//			
//			return "studentResult";
//		}
//		@ModelAttribute   //How to get a specific field from the object, you need to use ModelAttribute
//		public void studentGreet(Model m, Student student)
//		{
//			m.addAttribute("greetStudent", student.getName());
//		}
	
	//How to use Get Method
	
	//1.way
	 /*
	     1) Inside the methos parantehsis type "methos=ReqeuestMethos.GET"
	     2)Go to index.jsp and add "methos=get"inside the form tag
	     3)Go to result.jsp file and type ==>${studentList}
	  */
//	@RequestMapping(value="getStudent", method=RequestMethod.GET)
//	public String getStudent(Model m) {
//		List <Student>students= new ArrayList<>();
//		students.add(new Student(101,"Ali Can"));
//		students.add(new Student(102,"Veli Can"));
//		students.add(new Student(103,"Mary Star"));
//		students.add(new Student(104,"Tom Hanks"));
//		students.add(new Student(105,"Angie Ocean"));
//		m.addAttribute("studentList", students);
//		return "studentResult";
//	}
	
	//2.way
	
//	@GetMapping(value="getStudent")
//	public String getStudent(Model m) {
//		List <Student>students= new ArrayList<>();
//		students.add(new Student(101,"Ali Can"));
//		students.add(new Student(102,"Veli Can"));
//		students.add(new Student(103,"Mary Star"));
//		students.add(new Student(104,"Tom Hanks"));
//		students.add(new Student(105,"Angie Ocean"));
//		m.addAttribute("studentList", students);
//		return "studentResult";
//	}
	
//hot to get a specific student 
	
	
	@GetMapping(value="getStudentWithId")
	public String getSpecificStudent(@RequestParam("id") int id, Model m) {
		
		List <Student>students= new ArrayList<>();
		students.add(new Student(101,"Ali Can"));
		students.add(new Student(102,"Veli Can"));
		students.add(new Student(103,"Mary Star"));
		students.add(new Student(104,"Tom Hanks"));
		students.add(new Student(105,"Angie Ocean"));
		
		int idx=-1;//index value normally cannot be -, but if we put 0 its the 1st index->-1 is a false index
		for(Student w:students) {
			if(id==w.getId()) {
				idx=students.indexOf(w);
				
			}
		}
		if(idx==-1) //means there is not such id
			{m.addAttribute("specificStudent", "There is no such ID");}
		else
		{
			m.addAttribute("specificStudent",students.get(idx));
			}
		return "studentResult";
	}
}