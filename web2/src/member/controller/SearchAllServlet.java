package member.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class SearchAllServlet
 */
@WebServlet(name = "SearchAll", urlPatterns = { "/searchAll" })
public class SearchAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchAllServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false); //관리자가 요청한 것인지 재확인

		if((session.getAttribute("user")!=null) && ((Member)session.getAttribute("user")).getUserId().equals("admin"))
		{
			ArrayList<Member> list = new MemberService().searchAll();

			if(list.isEmpty()) {
			}
			else{	
				RequestDispatcher view = request.getRequestDispatcher("/views/member/allMember.jsp");
				request.setAttribute("userList",list);
				view.forward(request,response);
			}
		}
		else
		{
			response.sendRedirect("/views/member/Error.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
