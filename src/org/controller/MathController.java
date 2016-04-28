package org.controller;

import java.util.ArrayList;
import java.util.List;

//import org.apache.poi.hssf.model.Model;
import org.model.MathModel;
import org.model.Student;
import org.service.IMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MathController {
	
	@Autowired
	IMath iMath;
	
	@RequestMapping(value="open")
	public String openumathdemo(Model model) {
		
		MathModel mathmodel=new MathModel();
		model.addAttribute("mathmodel", mathmodel);
		return "mathdemo";
	}
	
	@RequestMapping(value="sum")
	public String sumurl( @ModelAttribute MathModel mathmodel, Model model) {
		
	mathmodel=	iMath.sum(mathmodel);
	ArrayList<String> strings =new ArrayList<String>();

	
	
	
		model.addAttribute("mathmodel", mathmodel);
		model.addAttribute("strings", strings);
		return "mathdemo";
	}
	@RequestMapping(value="openstudent")
	public String openstudent(Model model) {
		
		Student student=new Student();
		model.addAttribute("student", student);
		return "StudentEntry";
	}
	
	@RequestMapping(value="studententry")
	public String saveurl( @ModelAttribute Student student, Model model) {
		
		
	iMath.savestudent(student);
	
	
		
		model.addAttribute("student", student);
		return "StudentEntry";
	}

	@RequestMapping(value="showuser")
	public String showStudenturl(Model model)
	{System.out.println(22);
		List<Student> students=iMath.showStudent();
		
		System.out.println("showuser");
		model.addAttribute("students", students);
		return "StudentEntry";
	}
}
