package board.model.vo;

public class Board {
	int rNum;
	int boardNo;
	String boardTitle;
	String boardWriter;
	String boardContent;
	String boardDate;
	String filename;
	String filepath;
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int boardNo, String boardTitle, String boardWriter, String boardContent, String boardDate,
			String filename) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.filename = filename;
	}
	/**
	 * @return the boardNo
	 */
	public int getBoardNo() {
		return boardNo;
	}
	/**
	 * @param boardNo the boardNo to set
	 */
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	/**
	 * @return the boardTitle
	 */
	public String getBoardTitle() {
		return boardTitle;
	}
	/**
	 * @param boardTitle the boardTitle to set
	 */
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	/**
	 * @return the boardWriter
	 */
	public String getBoardWriter() {
		return boardWriter;
	}
	/**
	 * @param boardWriter the boardWriter to set
	 */
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	/**
	 * @return the boardContent
	 */
	public String getBoardContent() {
		return boardContent;
	}
	public String getBoardContentBr() {
		return boardContent.replaceAll("\r\n", "<br>");
	}
	/**
	 * @param boardContent the boardContent to set
	 */
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	/**
	 * @return the boardDate
	 */
	public String getBoardDate() {
		return boardDate;
	}
	/**
	 * @param boardDate the boardDate to set
	 */
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
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
