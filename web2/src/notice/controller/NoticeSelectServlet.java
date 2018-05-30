package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;

/**
 * Servlet implementation class NoticeSelectServlet
 */
@WebServlet(name = "NoticeSelect", urlPatterns = { "/noticeSelect" })
public class NoticeSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2. view에서 보낸 데이터를 변수에 저장
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		//3. 비즈니스 로직 (공지사항 내용)_
		Notice notice = new NoticeService().noticeSelect(noticeNo);
		
		//3. 비즈니스 로직 (댓글 내용)
		ArrayList<NoticeComment>list = new NoticeService().noticeComment(noticeNo);
		
		//4. view에 결과 출력
		if(notice !=null) {
			RequestDispatcher view = request.getRequestDispatcher("/views/notice/noticeSelect.jsp");
			request.setAttribute("notice", notice); //선택한 공지 내용
			request.setAttribute("comment", list); // 댓글
			view.forward(request, response);
		}else {
			response.sendRedirect("/views/notice/Error.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
