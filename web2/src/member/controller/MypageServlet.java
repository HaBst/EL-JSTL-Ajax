package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet(name = "Mypage", urlPatterns = { "/mypage" })
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Member m = new Member();
		if(session.getAttribute("user") !=null) {
			m = new MemberService().selectOne(((Member)session.getAttribute("user")).getUserId(),
											((Member)session.getAttribute("user")).getUserPwd());
			if(m!=null) {
			RequestDispatcher view = request.getRequestDispatcher("/views/member/myPage.jsp");
			request.setAttribute("userInfo", m);
			view.forward(request, response);
			}else {
				response.sendRedirect("/views/member/myPageError");
			}
			
		}else {// 로그인을 하지않고 요청했을 경우(비정상 접근)
			response.sendRedirect("/views/member/myPageError");
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
