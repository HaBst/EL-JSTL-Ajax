package file.model.vo;

import java.sql.Timestamp;

public class DataFile {
	private String fileName;
	private String filePath;
	private long filesize;
	private String fileUser;
	private Timestamp uploadTime;
	
	public DataFile() {}
	public DataFile(String fileName, String filePath, long filesize, String fileUser, Timestamp uploadTime) {
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
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public String getFileUser() {
		return fileUser;
	}
	public void setFileUser(String fileUser) {
		this.fileUser = fileUser;
	}
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}
}
