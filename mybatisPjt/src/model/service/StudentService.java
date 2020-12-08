package model.service;

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

}
