package file.model.vo;

import oracle.sql.TIMESTAMP;

public class DataFile {
	private String fileName;
	private String filePath;
	private int filesize;
	private String fileUser;
	private TIMESTAMP uploadTime;
	
	public DataFile() {}
	public DataFile(String fileName, String filePath, int filesize, String fileUser, TIMESTAMP uploadTime) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
		this.filesize = filesize;
		this.fileUser = fileUser;
		this.uploadTime = uploadTime;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public String getFileUser() {
		return fileUser;
	}
	public void setFileUser(String fileUser) {
		this.fileUser = fileUser;
	}
	public TIMESTAMP getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(TIMESTAMP uploadTime) {
		this.uploadTime = uploadTime;
	}
}
