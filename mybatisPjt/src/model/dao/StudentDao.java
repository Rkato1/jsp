package model.dao;

import org.apache.ibatis.session.SqlSession;

import model.vo.Student;

public class StudentDao {

	public int insert(SqlSession session, Student s) {
		return session.insert("stu.insertStudent",s);
	}

	public Student searchStudent(SqlSession session, int stuNo) {		 
		return session.selectOne("stu.searchStudent",stuNo);
	}

}
