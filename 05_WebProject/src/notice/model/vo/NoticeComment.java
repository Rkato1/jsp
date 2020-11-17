package notice.model.vo;

public class NoticeComment {
	int noticeCommentNo;
	int noticeCommentLevel;
	String noticeCommentWriter;
	String noticeCommentContent;
	int noticeRef;
	int noticeCommentRef;
	String noticeCommentDate;
	public NoticeComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeComment(int noticeCommentNo, int noticeCommentLevel, String noticeCommentWriter,
			String noticeCommentContent, int noticeRef, int noticeCommentRef, String noticeCommentDate) {
		super();
		this.noticeCommentNo = noticeCommentNo;
		this.noticeCommentLevel = noticeCommentLevel;
		this.noticeCommentWriter = noticeCommentWriter;
		this.noticeCommentContent = noticeCommentContent;
		this.noticeRef = noticeRef;
		this.noticeCommentRef = noticeCommentRef;
		this.noticeCommentDate = noticeCommentDate;
	}
	/**
	 * @return the noticeCommentNo
	 */
	public int getNoticeCommentNo() {
		return noticeCommentNo;
	}
	/**
	 * @param noticeCommentNo the noticeCommentNo to set
	 */
	public void setNoticeCommentNo(int noticeCommentNo) {
		this.noticeCommentNo = noticeCommentNo;
	}
	/**
	 * @return the noticeCommentLevel
	 */
	public int getNoticeCommentLevel() {
		return noticeCommentLevel;
	}
	/**
	 * @param noticeCommentLevel the noticeCommentLevel to set
	 */
	public void setNoticeCommentLevel(int noticeCommentLevel) {
		this.noticeCommentLevel = noticeCommentLevel;
	}
	/**
	 * @return the noticeCommentWriter
	 */
	public String getNoticeCommentWriter() {
		return noticeCommentWriter;
	}
	/**
	 * @param noticeCommentWriter the noticeCommentWriter to set
	 */
	public void setNoticeCommentWriter(String noticeCommentWriter) {
		this.noticeCommentWriter = noticeCommentWriter;
	}
	/**
	 * @return the noticeCommentContent
	 */
	public String getNoticeCommentContent() {
		return noticeCommentContent;
	}
	public String getNoticeCommentContentBr() {
		return noticeCommentContent.replaceAll("\r\n", "<br>");
	}
	/**
	 * @param noticeCommentContent the noticeCommentContent to set
	 */
	public void setNoticeCommentContent(String noticeCommentContent) {
		this.noticeCommentContent = noticeCommentContent;
	}
	/**
	 * @return the noticeRef
	 */
	public int getNoticeRef() {
		return noticeRef;
	}
	/**
	 * @param noticeRef the noticeRef to set
	 */
	public void setNoticeRef(int noticeRef) {
		this.noticeRef = noticeRef;
	}
	/**
	 * @return the noticeCommentRef
	 */
	public int getNoticeCommentRef() {
		return noticeCommentRef;
	}
	/**
	 * @param noticeCommentRef the noticeCommentRef to set
	 */
	public void setNoticeCommentRef(int noticeCommentRef) {
		this.noticeCommentRef = noticeCommentRef;
	}
	/**
	 * @return the noticeCommentDate
	 */
	public String getNoticeCommentDate() {
		return noticeCommentDate;
	}
	/**
	 * @param noticeCommentDate the noticeCommentDate to set
	 */
	public void setNoticeCommentDate(String noticeCommentDate) {
		this.noticeCommentDate = noticeCommentDate;
	}
	
}
