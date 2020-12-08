package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlsessionTemplate {
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String config="mybatis-config.xml";
		try {
			//mybatis-config.xml파일과 input stream 생성
			InputStream is = Resources.getResourceAsStream(config);
			//SqlSessionFactory를 만들수 있는 팩토리 빌더 생성
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			//팩토리 빌더를 통해 실제 SqlSession을 만드는 SqlSessionFactory생성
			SqlSessionFactory factory = builder.build(is);
			//SqlSession 객체생성->매개변수  false는 autocommit해제
			session = factory.openSession(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
}
