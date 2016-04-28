package org.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.model.MathModel;
import org.model.Student;
import org.springframework.stereotype.Service;
import org.util.HibernateUtil;

@Service
public class MathService implements IMath {

	@Override
	public MathModel sum(MathModel mathModel) {
		int temp= mathModel.getNum1()+mathModel.getNum2();
		mathModel.setRes(temp);
		return mathModel;
	}

	@Override
	public void savestudent(Student student) {
		
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session =factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.save(student);
		
		transaction.commit();
		session.close();
		
		
	}

	@Override
	public List<Student> showStudent() {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session =factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Criteria criteria=session.createCriteria(Student.class);
		List<Student> students=criteria.list();
		
		transaction.commit();
		session.close();
		return students;
	}
	

}
