package notice.model.vo;

import java.sql.Date;

public class NoticeComment {
	private int commentNo;
	private int noticeNo;
	private String content;
	private String userId;
	private Date regDate;
	
	public NoticeComment() {}
	public NoticeComment(int commentNo, int noticeNo, String content, String userId, Date regDate) {
		super();
		this.commentNo = commentNo;
		this.noticeNo = noticeNo;
		this.content = content;
		this.userId = userId;
		this.regDate = regDate;
	}
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	
	
}
/*
COMMENTNO	NUMBER
NOTICENO	NUMBER
CONTENT	VARCHAR2(300 BYTE)
USERID	VARCHAR2(20 BYTE)
REGDATE	DATE
*/