package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet(name = "NoticeUpdate", urlPatterns = { "/noticeUpdate" })
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

//		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
//		String title = request.getParameter("title");
//		String contents = request.getParameter("contents");
		
		Notice n = new Notice();
		n.setNoticeNo(Integer.parseInt(request.getParameter("noticeNo")));
		n.setSubject(request.getParameter("title"));
		n.setContents(request.getParameter("contents"));
		
		HttpSession session = request.getSession(false);
		
//		Notice notice = new NoticeService().noticeUpdate(n);
		
		if(session.getAttribute("user")!=null &&((Member)session.getAttribute("user")).getUserId().equals("admin")) {
			int result = new NoticeService().noticeUpdate(n);
			if(result > 0) {
			response.sendRedirect("/noticeSelect?noticeNo="+n.getNoticeNo());
			}
			else {
				response.sendRedirect("/views/notice/Error.html");
			}
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
