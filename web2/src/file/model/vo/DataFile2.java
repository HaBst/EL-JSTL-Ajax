package file.model.vo;

import java.sql.Timestamp;

public class DataFile2 {
	private String beforeFileName;
	private String afterFileName;
	private String filePath;
	private long fileSize;
	private String fileUser;
	private Timestamp uploadTime;
	
	public DataFile2() {}
	public DataFile2(String beforeFileName, String afterFileName, String filePath, long fileSize, String fileUser,
			Timestamp uploadTime) {
		super();
		this.beforeFileName = beforeFileName;
		this.afterFileName = afterFileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.fileUser = fileUser;
		this.uploadTime = uploadTime;
	}
	
	public String getBeforeFileName() {
		return beforeFileName;
	}
	public void setBeforeFileName(String beforeFileName) {
		this.beforeFileName = beforeFileName;
	}
	public String getAfterFileName() {
		return afterFileName;
	}
	public void setAfterFileName(String afterFileName) {
		this.afterFileName = afterFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
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
