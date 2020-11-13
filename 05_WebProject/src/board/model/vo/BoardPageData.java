package board.model.vo;

import java.util.ArrayList;

public class BoardPageData {
	ArrayList<Board> list;
	String pageNavi;
	public BoardPageData(ArrayList<Board> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public BoardPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the list
	 */
	public ArrayList<Board> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<Board> list) {
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
