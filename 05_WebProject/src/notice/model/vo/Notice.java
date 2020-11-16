package notice.model.vo;

public class Notice {
	int rNum;
	int noticeNo;
	String noticeTitle;
	String noticeWriter;
	String noticeContent;
	String noticeDate;
	String filename;
	String filepath;
	
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(int noticeNo, String noticeTitle, String noticeWriter, String noticeContent, String noticeDate,
			String filename) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.filename = filename;
	}
	/**
	 * @return the noticeNo
	 */
	public int getNoticeNo() {
		return noticeNo;
	}
	/**
	 * @param noticeNo the noticeNo to set
	 */
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	/**
	 * @return the noticeTitle
	 */
	public String getNoticeTitle() {
		return noticeTitle;
	}
	/**
	 * @param noticeTitle the noticeTitle to set
	 */
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	/**
	 * @return the noticeWriter
	 */
	public String getNoticeWriter() {
		return noticeWriter;
	}
	/**
	 * @param noticeWriter the noticeWriter to set
	 */
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	/**
	 * @return the noticeContent
	 */
	public String getNoticeContent() {
		return noticeContent;
	}
	//자바에서의 개행과 html에서의 개행이 다르므로 변환
	public String getNoticeContentBr() {
		return noticeContent.replaceAll("\r\n", "<br>");
	}
	/**
	 * @param noticeContent the noticeContent to set
	 */
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	/**
	 * @return the noticeDate
	 */
	public String getNoticeDate() {
		return noticeDate;
	}
	/**
	 * @param noticeDate the noticeDate to set
	 */
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getFilepath() {
		return filepath;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	/**
	 * @return the rNum
	 */
	public int getrNum() {
		return rNum;
	}
	/**
	 * @param rNum the rNum to set
	 */
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	
}
