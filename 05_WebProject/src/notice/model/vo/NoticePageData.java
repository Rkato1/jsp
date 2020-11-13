package notice.model.vo;

import java.util.ArrayList;

public class NoticePageData {
	ArrayList<Notice> list;
	String pageNavi;
	public NoticePageData(ArrayList<Notice> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public NoticePageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the list
	 */
	public ArrayList<Notice> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<Notice> list) {
		this.list = list;
	}
	/**
	 * @return the pageNavi
	 */
	public String getPageNavi() {
		return pageNavi;
	}
	/**
	 * @param pageNavi the pageNavi to set
	 */
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
