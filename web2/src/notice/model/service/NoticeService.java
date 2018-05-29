package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;
import notice.model.vo.PageData;

public class NoticeService {

	public PageData noticeAll(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		//Service 에서는 2가지 값을 정해야 함
		//1. 한 페이지당 보이는 리스트의 개수 (게시물의 개수)
		//2. 현재 위치를 중심으로 시작  navi에서부터 끝  navi개수

		int recordCountPerPage = 10;// 한 페이지당 보이는 리스트의 개수(현재 보이는 페이지번호의 리스트)
		int naviCountPerPage = 5; // 현재 위치를 중심으로 시작 navi에서부터 끝 navi 개수(하단의 페이지번호)

		// Service에서는 DAO에 2가지 요청을 진행 해야 함
		// 1. 현재 페이지 리스트
		// 2. 현재 중심으로 만들어지는 navi 리스트

		ArrayList<Notice> list = new NoticeDAO().getCurrentPage(conn,currentPage,recordCountPerPage);
		//커넥션과 현재 페이지정보와 몇개씩 가져올지를 넘겨줌
		String pageNavi = new NoticeDAO().getPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage);

		PageData pd = null;
		if(!list.isEmpty() && !pageNavi.isEmpty()) { //list와 pageNavi가 제대로 들어왔다면
			pd = new PageData();
			pd.setNoticeList(list);
			pd.setPageNavi(pageNavi);
		}
		JDBCTemplate.connclose(conn);
		return pd;
	}

	public PageData searchSub(String searchSub, int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		//Service 에서는 2가지 값을 정해야 함
		//1. 한 페이지당 보이는 리스트의 개수 (게시물의 개수)
		//2. 현재 위치를 중심으로 시작  navi에서부터 끝  navi개수

		int recordCountPerPage = 10; // 한 페이지당 보이는 리스트의 개수(현재 보이는 페이지번호의 리스트)
		int naviCountPerPage = 5; // 현재 위치를 중심으로 시작 navi에서부터 끝 navi 개수(하단의 페이지번호)

		// Service에서는 DAO에 2가지 요청을 진행 해야 함
		// 1. 현재 페이지 리스트
		// 2. 현재 중심으로 만들어지는 navi 리스트

		ArrayList<Notice> list = new NoticeDAO().getsearchSub(conn, currentPage, recordCountPerPage,searchSub);

		String pageNavi = new NoticeDAO().getSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, searchSub);

		PageData pd = null;
		if(!list.isEmpty() && !pageNavi.isEmpty()) { //list와 pageNavi가 제대로 들어왔다면
			pd = new PageData();
			pd.setNoticeList(list);
			pd.setPageNavi(pageNavi);
		}
		JDBCTemplate.connclose(conn);
		return pd;

	}

}
