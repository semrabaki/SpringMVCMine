package com.techproed.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
	
	
	//How to get primitive data types
	
//	@RequestMapping("add") //the parameter should be the same as the action in the form
//	public String addNums1 (HttpServletRequest req) {
//		
//		int a=Integer.parseInt(req.getParameter("n1")); //This method return a string so we are converting
//		int b=Integer.parseInt(req.getParameter("n2"));
//		int sum=a+b;
//		
//		int product= a*b;
//		
//		HttpSession session= req.getSession();  //This is how you create a session
//		session.setAttribute("sumOfTwoIntegers", sum); //for every operation you need to set an attribute after you create a session
//		
//	    session.setAttribute("productOfTwoIntegers", product);
//		
//		return "result";
//		
//	}
	
	//2.way
//	@RequestMapping("add")
//	public String addNums2(@RequestParam("n1") int a, @RequestParam("n2")int b, HttpSession session)
//	{
//		int sum= a+b;
//		int product= a*b;
//		session.setAttribute("sumOfTwoIntegers",sum);
//		session.setAttribute("productOfTwoIntegers", product);
//		
//		return "result";
//	}
	
	
	//3. way
	
//	@RequestMapping("add")
//	public ModelAndView addNums3(@RequestParam("n1") int a, @RequestParam("n2")int b)
//	{
//		ModelAndView mv= new ModelAndView(); //this is a class
//		mv.setViewName("result"); //this gives the page reference? where to show the result
//		int sum= a+b;
//		int product= a*b;
//		mv.addObject("sumOfTwoIntegers",sum);
//		mv.addObject("productOfTwoIntegers", product);
//		
//		return mv;
//	}
	
	//4.way //This is the most preferred way
//	@RequestMapping("add")
//	public ModelAndView addNums4(@RequestParam("n1") int a, @RequestParam("n2")int b)
//	{
//		ModelAndView mv= new ModelAndView("result"); //this gives the page reference? where to show the result we gave it as constructor parameter
//		int sum= a+b;
//		int product= a*b;
//		mv.addObject("sumOfTwoIntegers",sum);
//		mv.addObject("productOfTwoIntegers", product);
//		
//		return mv;
//	}
	
//	//5.way //This is showing the usage model interface
//	@RequestMapping("add") 
//	public String addNums4(@RequestParam("n1") int a, @RequestParam("n2")int b, Model m)
//	{
//		int sum= a+b;
//		int product= a*b;
//		//First usage of model interface
////		m.addAttribute("sumOfTwoIntegers",sum);
////		m.addAttribute("productOfTwoIntegers", product);
//
//		//Second usage:
//		m.addAttribute("sumOfTwoIntegers",sum).addAttribute("productOfTwoIntegers",product);
//		return "result";
//	}
	
	//6.way Model Mapping
	@RequestMapping("add")
	public String addNums6(@RequestParam("n1") int a, @RequestParam("n2")int b, ModelMap mm)
	{
	
		int sum= a+b;
		int product= a*b;
		//First Usage
		mm.addAttribute("sumOfTwoIntegers",sum);
		mm.addAttribute("productOfTwoIntegers", product);
		
		//Second Usage( chaining)
		//mm.addAttribute("sumOfTwoIntegers",sum).addAttribute("productOfTwoIntegers", product);
		
		return "result";
	}
	
	
	}


