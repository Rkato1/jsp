package model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.vo.Student;

public class StudentDao {

	public int insert(SqlSession session, Student s) {
		return session.insert("stu.insertStudent",s);
	}

	public Student searchStudent(SqlSession session, int stuNo) {		 
		return session.selectOne("stu.searchStudent",stuNo);
	}

	public ArrayList<Student> searchAllStudent(SqlSession session) {
		List<Student> list = session.selectList("stu.searchAllStudent");
		return (ArrayList<Student>)list;
	}

	public int deleteStudent(SqlSession session, int stuNo) {		
		return session.delete("stu.deleteStudent",stuNo);
	}

	public int updateStudent(SqlSession session, HashMap<String, Object> map) {
		return session.update("stu.updateStudent",map);
	}

}
