package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class JoinusServlet
 */
@WebServlet(name = "Joinus", urlPatterns = { "/joinus" })
public class JoinusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Member m = new Member();
		m.setUserId(request.getParameter("userId"));
		if(request.getParameter("userPwd").equals(request.getParameter("userPwd_re")) ) {
		m.setUserPwd(request.getParameter("userPwd"));
		}
		m.setUserName(request.getParameter("userName"));
		m.setUserAge(Integer.parseInt(request.getParameter("Age")));
		m.setUserEmail(request.getParameter("Email"));
		m.setUserPhone(request.getParameter("Phone"));
		m.setUserAddr(request.getParameter("addr"));
		m.setUserGender(request.getParameter("gender"));
		m.setUserHobby(request.getParameter("hobby"));
		
		if(new MemberService().memberInsert(m)>0) {
			response.sendRedirect("/views/member/insertSuccess.jsp");
		}else {
			response.sendRedirect("/views/member/insertFail.jsp");
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
