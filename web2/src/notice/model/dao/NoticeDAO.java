package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.vo.Notice;

public class NoticeDAO {



	public ArrayList<Notice> getCurrentPage(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		
		// 페이지 시작 계산(시작 게시물)
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
			// 만약 요청한 페이지가 1페이지 라면? ->1
			// 1 * 10 - (10-1) => 1
			// 만약 요청한 페이지가 3페이지 라면? ->21
			// 3 * 10 - (10-1) => 21
		
		
		// 페이지 끝 계산(끝 게시물)
		int end = currentPage*recordCountPerPage;
			// 만약 요청한 페이지가 1페이지라면? -> 10;
			// 1 * 10 => 10
			// 만약 요청한 페이지가 3페이지라면? -> 30;
			// 3 * 10 => 30
		
		// 글 번호를 서브쿼리로 하여 페이지당 개시물 개수
		String query = "select * from" 
				+ "(select notice.*,row_number() "
				+ "over(order by noticeno desc)as num"
				+ " from notice)" 
				+ "where num between ? and ?";
		ArrayList<Notice>list = new ArrayList<Notice>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("noticeno"));
				n.setSubject(rset.getString("subject"));
				n.setContents(rset.getString("contents"));
				n.setUserId(rset.getString("userid"));
				n.setRegDate(rset.getDate("regdate"));
				list.add(n);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public String getPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 게시물의 토탈 개수를 구해야 함
		int recordTotalCount=0;
		// 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)
		String query = "select count(*)as totalCount from notice";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		//게시물 124개 -> navi 13페이지
		int pageTotalCount  = 0; // navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만드려면?
		// 토탈 게시물이 124개 라고 했을때 124%10을 한 후 +1 만듬
		// 만들어야 함
		// 만약 나머지가 0으로 떨어 진다면 +1을 하지 않음
		if(recordTotalCount % recordCountPerPage !=0) {
			pageTotalCount = recordTotalCount / recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage; 
		}
		//사용자가 현재 페이지가 1페이지 인데 더 아래 페이지를 요청할 경우
		// 혹은 마지막 페이지가 120 페이지 인데 다음 페이지를
		// 요청할 경우에 대한 에러 방지 설정
		// 1보다 아래를 요청하면 1로 셋팅
		// 마지막보다 다음 페이지를 요청하면 마지막 페이지 값으로 셋팅
		
		if(currentPage <1) { //currentPage가 1보다 작을 경우 1로 고정
			currentPage =1;
		}else if(currentPage>pageTotalCount) {//currentPage가 pageTotalCount보다 클 경우 같게 만듦
			currentPage = pageTotalCount;
		}
		// 현재 페이지를 기병으로 시작 navi와 끝 navi를 만들어야 함
		// 현재 페이지가 1이라면 ? 1 ~ 5;
		// 현재 페이지가 3이라면 ? 1 ~ 5;
		// 현재 페이지가 7이라면 ? 6 ~ 10;
		// 현재 페이지가 12이라면 ? 11 ~ 15;
		// 시작페이지 구하는 공식은?
		//-> ((현재페이지-1)/리스트개수)* 리스트 개수 +1
		// 만약 1페이지 라면?
		//-> ((1-1)/5)*5+1 => 시작 페이지는 1
		// 만약 3페이지 라면?
		//-> ((3-1)/5)*5+1 => 시작 페이지는 1
		// 만약 7페이지 라면?
		//-> ((7-1)/5)*5+1 => 시작 페이지는 6
		// 만약 12페이지 라면?
		//-> ((12-1)/5)*5+1 => 시작 페이지는 11
		
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		// 끝 navi 구하는 공식 (쉬움)
		// 시작navi + 보여줄 navi 개수 -1;
		// 만약 시작 navi 1이라면?
		// 1 + 5 -1 => 5
		int endNavi = startNavi + naviCountPerPage -1;
		
		// 끝 navi를 구할때 주의 해야 할점
		// 토탈 navi가 122라고 할때!
		// 시작 navi => (121-1)/5)*5+1 = 121
		// 끝 navi => 121 + 5 - 1 = 125
		// 이렇기 때문에 마지막 navi부분은  아래 코드를 추가 해야 함
		if(endNavi>pageTotalCount) { 
			//마지막 navi가 pageTotalCount보다 크다면 마지막 navi값을 pageTotalCount값으로 해라
			endNavi = pageTotalCount;
		}
		
		// 페이지 navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요 없으므로 !)
		
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi==1) { //startNavi가 1이라면 '<'버튼 false
			needPrev = false;
		}
		if(endNavi ==pageTotalCount) {//endNavi와 pageTotalCount가 같다면'>'버튼 false
			needNext=false;
		}
		
		// 여기까지 기본적인 구조는 끝남
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) { //시작이 1페이지가 아니라면!(needPrev에는 이미 true 또는 false가 들어가있다)
//			sb.append("<a href='/notice?currentPage="+(startNavi-5)+"'> << </a>"); // '<<' 출력
			sb.append("<a href='/notice?currentPage="+(startNavi-1)+"'> < </a>"); // '<' 출력
			
			
		}
		for(int i = startNavi; i <=endNavi; i++) {//1부터 5까지
			if(i==currentPage) {
				sb.append("<a href='/notice?currentPage="+i+"'><B> "+ i +" </B></a>"); //현재 들어가있는 페이지에 Bold속성 추가
			}else {
				sb.append("<a href='/notice?currentPage="+i+"'> "+i+" </a>");
			}
		}
		
		if(needNext){ // 끝페이지가 아니라면!
			sb.append("<a href='/notice?currentPage="+(endNavi+1)+"'> > </a>");
//			sb.append("<a href='/notice?currentPage="+(endNavi+5)+"'> >> </a>"); // '>>' 출력
		}
		return sb.toString();
	}

	public ArrayList<Notice> getsearchSub(Connection conn, int currentPage, int recordCountPerPage, String searchSub) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		
		String query = "select * from" 
				+ "(select notice.*,row_number() "
				+ "over(order by noticeno desc)as num "
				+ "from notice where subject like ?) " 
				+ "where num between ? and ?";
		ArrayList<Notice>list = new ArrayList<Notice>();

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchSub+"%");

			pstmt.setInt(2, start);

			pstmt.setInt(3, end);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("noticeno"));
				n.setSubject(rset.getString("subject"));
				n.setContents(rset.getString("contents"));
				n.setUserId(rset.getString("userid"));
				n.setRegDate(rset.getDate("regdate"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);;
		}
	
		return list;
	}

	public String getSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String searchSub) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 게시물의 토탈 개수를 구해야 함
		int recordTotalCount=0;
		// 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)
		String query = "select count(*)as totalCount from notice where subject like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchSub+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		//게시물 124개 -> navi 13페이지
		int pageTotalCount  = 0; // navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만드려면?
		// 토탈 게시물이 124개 라고 했을때 124%10을 한 후 +1 만듬
		// 만들어야 함
		// 만약 나머지가 0으로 떨어 진다면 +1을 하지 않음
		if(recordTotalCount % recordCountPerPage !=0) {
			pageTotalCount = recordTotalCount / recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage; 
		}
		//사용자가 현재 페이지가 1페이지 인데 더 아래 페이지를 요청할 경우
		// 혹은 마지막 페이지가 120 페이지 인데 다음 페이지를
		// 요청할 경우에 대한 에러 방지 설정
		// 1보다 아래를 요청하면 1로 셋팅
		// 마지막보다 다음 페이지를 요청하면 마지막 페이지 값으로 셋팅
		
		if(currentPage <1) { //currentPage가 1보다 작을 경우 1로 고정
			currentPage =1;
		}else if(currentPage>pageTotalCount) {//currentPage가 pageTotalCount보다 클 경우 같게 만듦
			currentPage = pageTotalCount;
		}
		// 현재 페이지를 기병으로 시작 navi와 끝 navi를 만들어야 함
		// 현재 페이지가 1이라면 ? 1 ~ 5;
		// 현재 페이지가 3이라면 ? 1 ~ 5;
		// 현재 페이지가 7이라면 ? 6 ~ 10;
		// 현재 페이지가 12이라면 ? 11 ~ 15;
		// 시작페이지 구하는 공식은?
		//-> ((현재페이지-1)/리스트개수)* 리스트 개수 +1
		// 만약 1페이지 라면?
		//-> ((1-1)/5)*5+1 => 시작 페이지는 1
		// 만약 3페이지 라면?
		//-> ((3-1)/5)*5+1 => 시작 페이지는 1
		// 만약 7페이지 라면?
		//-> ((7-1)/5)*5+1 => 시작 페이지는 6
		// 만약 12페이지 라면?
		//-> ((12-1)/5)*5+1 => 시작 페이지는 11
		
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		// 끝 navi 구하는 공식 (쉬움)
		// 시작navi + 보여줄 navi 개수 -1;
		// 만약 시작 navi 1이라면?
		// 1 + 5 -1 => 5
		int endNavi = startNavi + naviCountPerPage -1;
		
		// 끝 navi를 구할때 주의 해야 할점
		// 토탈 navi가 122라고 할때!
		// 시작 navi => (121-1)/5)*5+1 = 121
		// 끝 navi => 121 + 5 - 1 = 125
		// 이렇기 때문에 마지막 navi부분은  아래 코드를 추가 해야 함
		if(endNavi>pageTotalCount) { 
			//마지막 navi가 pageTotalCount보다 크다면 마지막 navi값을 pageTotalCount값으로 해라
			endNavi = pageTotalCount;
		}
		
		// 페이지 navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요 없으므로 !)
		
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi==1) { //startNavi가 1이라면 '<'버튼 false
			needPrev = false;
		}
		if(endNavi ==pageTotalCount) {//endNavi와 pageTotalCount가 같다면'>'버튼 false
			needNext=false;
		}
		
		// 여기까지 기본적인 구조는 끝남
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) { //시작이 1페이지가 아니라면!(needPrev에는 이미 true 또는 false가 들어가있다)
//			sb.append("<a href='/notice?currentPage="+(startNavi-5)+"'> << </a>"); // '<<' 출력
			sb.append("<a href='/searchSub?searchSub="+searchSub+"&currentPage="+(startNavi-1)+"'> < </a>"); // '<' 출력
			
			
		}
		for(int i = startNavi; i <=endNavi; i++) {//1부터 5까지
			if(i==currentPage) {
				sb.append("<a href='/searchSub?searchSub="+searchSub+"&currentPage="+i+"'><B> "+ i +" </B></a>"); //현재 들어가있는 페이지에 Bold속성 추가
			}else {
				sb.append("<a href='/searchSub?searchSub="+searchSub+"&currentPage="+i+"'> "+i+" </a>");
			}
		}
		
		if(needNext){ // 끝페이지가 아니라면!
			sb.append("<a href='/searchSub?searchSub="+searchSub+"&currentPage="+(endNavi+1)+"'> > </a>");
//			sb.append("<a href='/notice?currentPage="+(endNavi+5)+"'> >> </a>"); // '>>' 출력
		}
		return sb.toString();
	}

	public Notice noticeSelect(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice where noticeno=?";
		Notice notice = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				notice.setNoticeNo(rset.getInt("noticeno"));
				notice.setSubject(rset.getString("subject"));
				notice.setContents(rset.getString("contents"));
				notice.setUserId(rset.getString("userid"));
				notice.setRegDate(rset.getDate("regdate"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return notice;
	}

	public int noticeUpdate(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		Notice notice = null;
		
		String query = "update notice set subject = ?,contents = ? where noticeno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, n.getSubject());
			pstmt.setString(2, n.getContents());
			pstmt.setInt(3, n.getNoticeNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}


}
