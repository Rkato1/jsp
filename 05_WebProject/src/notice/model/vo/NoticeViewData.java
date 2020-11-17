package notice.model.vo;

import java.util.ArrayList;

public class NoticeViewData {
	Notice n;
	ArrayList<NoticeComment> list;
	public NoticeViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeViewData(Notice n, ArrayList<NoticeComment> list) {
		super();
		this.n = n;
		this.list = list;
	}
	/**
	 * @return the n
	 */
	public Notice getN() {
		return n;
	}
	/**
	 * @param n the n to set
	 */
	public void setN(Notice n) {
		this.n = n;
	}
	/**
	 * @return the list
	 */
	public ArrayList<NoticeComment> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<NoticeComment> list) {
		this.list = list;
	}
	
}
