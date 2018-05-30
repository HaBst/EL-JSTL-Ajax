package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.NoticeComment;

/**
 * Servlet implementation class NoticeCommentUploadServlet
 */
@WebServlet(name = "NoticeCommentUpload", urlPatterns = { "/noticeCommentUpload" })
public class NoticeCommentUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user")!=null) {
			NoticeComment nc = new NoticeComment();
			
			nc.setUserId(((Member)session.getAttribute("user")).getUserId());
			nc.setContent(request.getParameter("comment"));
			nc.setNoticeNo(Integer.parseInt(request.getParameter("noticeNo")));
			
			int result = new NoticeService().noticeCommentUpload(nc);
			
			if(result > 0) {
				response.sendRedirect("/noticeSelect?noticeNo="+nc.getNoticeNo());
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
