package notice.model.vo;

import java.util.ArrayList;

public class PageData {
	private ArrayList<Notice> noticeList;
	private String pageNavi;
	
	public PageData() {} // 기본 생성자
	public PageData(ArrayList<Notice> noticeList, String pageNavi) {
		super();
		this.noticeList = noticeList;
		this.pageNavi = pageNavi;
	}
	public ArrayList<Notice> getNoticeList() {
		return noticeList;
	}
	public void setNoticeList(ArrayList<Notice> noticeList) {
		this.noticeList = noticeList;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
