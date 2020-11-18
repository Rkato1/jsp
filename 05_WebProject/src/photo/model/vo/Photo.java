package photo.model.vo;

public class Photo {
	int photoNo;
	String photoWriter;
	String photoContent;
	String filepath;
	String photoDate;
	int readCount;
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Photo(int photoNo, String photoWriter, String photoContent, String filepath, String photoDate,
			int readCount) {
		super();
		this.photoNo = photoNo;
		this.photoWriter = photoWriter;
		this.photoContent = photoContent;
		this.filepath = filepath;
		this.photoDate = photoDate;
		this.readCount = readCount;
	}
	/**
	 * @return the photoNo
	 */
	public int getPhotoNo() {
		return photoNo;
	}
	/**
	 * @param photoNo the photoNo to set
	 */
	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}
	/**
	 * @return the photoWriter
	 */
	public String getPhotoWriter() {
		return photoWriter;
	}
	/**
	 * @param photoWriter the photoWriter to set
	 */
	public void setPhotoWriter(String photoWriter) {
		this.photoWriter = photoWriter;
	}
	/**
	 * @return the photoContent
	 */
	public String getPhotoContent() {
		return photoContent;
	}
	/**
	 * @param photoContent the photoContent to set
	 */
	public void setPhotoContent(String photoContent) {
		this.photoContent = photoContent;
	}
	/**
	 * @return the filepath
	 */
	public String getFilepath() {
		return filepath;
	}
	/**
	 * @param filepath the filepath to set
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	/**
	 * @return the photoDate
	 */
	public String getPhotoDate() {
		return photoDate;
	}
	/**
	 * @param photoDate the photoDate to set
	 */
	public void setPhotoDate(String photoDate) {
		this.photoDate = photoDate;
	}
	/**
	 * @return the readCount
	 */
	public int getReadCount() {
		return readCount;
	}
	/**
	 * @param readCount the readCount to set
	 */
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	
}
