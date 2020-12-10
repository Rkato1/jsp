package model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import common.SqlsessionTemplate;
import model.dao.StudentDao;
import model.vo.Student;

public class StudentService {

	public int insert(Student s) {
		SqlSession session = SqlsessionTemplate.getSqlSession();
		int result = new StudentDao().insert(session,s);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public Student searchStudent(int stuNo) {
		SqlSession session = SqlsessionTemplate.getSqlSession();
		Student s = new StudentDao().searchStudent(session,stuNo);		
		session.close();
		return s;
	}

	public ArrayList<Student> searchAllStudent() {
		SqlSession session = SqlsessionTemplate.getSqlSession();
		ArrayList<Student> list = new StudentDao().searchAllStudent(session);		
		session.close();
		return list;
	}

	public int deleteStudent(int stuNo) {
		SqlSession session = SqlsessionTemplate.getSqlSession();
		int result = new StudentDao().deleteStudent(session, stuNo);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int updateStudent(int stuNo, String stuPhone, String email, String addr) {
		SqlSession session = SqlsessionTemplate.getSqlSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stuNo", stuNo);
		map.put("stuPhone", stuPhone);
		map.put("email", email);
		map.put("addr", addr);
		int result = new StudentDao().updateStudent(session, map);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

}

