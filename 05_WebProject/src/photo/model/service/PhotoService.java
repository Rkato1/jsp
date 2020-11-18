package photo.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import photo.model.dao.PhotoDao;
import photo.model.vo.Photo;

public class PhotoService {

	public int totalCount() {
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = new PhotoDao().totalCount(conn);
		JDBCTemplate.close(conn);
		return totalCount;
	}

	public int insertPhoto(Photo p) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new PhotoDao().insertPhoto(conn,p);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Photo> photoMore(int start) {
		Connection conn = JDBCTemplate.getConnection();
		//한번에 가지고 올 갯수
		int count = 5;
		int end=start+count-1;
		ArrayList<Photo> list = new PhotoDao().photoMore(conn,start,end);		
		JDBCTemplate.close(conn);
		return list;
	}

}
