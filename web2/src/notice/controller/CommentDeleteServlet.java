package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notice.model.service.NoticeService;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet(name = "CommentDelete", urlPatterns = { "/commentDelete" })
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") != null) {
			int commentNo = Integer.parseInt(request.getParameter("commentNo"));
			int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
			
			int result = new NoticeService().commentDelete(commentNo);
			
			if(result > 0) {
				response.sendRedirect("/noticeSelect?noticeNo="+noticeNo);
			}else {
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
