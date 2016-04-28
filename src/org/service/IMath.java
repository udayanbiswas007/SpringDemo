package org.service;

import java.util.List;

import org.model.MathModel;
import org.model.Student;

public interface IMath {
 public MathModel sum(MathModel mathModel);
 public void savestudent(Student student);
  public List<Student> showStudent();
	

 
}
