package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전송값에 한글이 있을 경우를 처리할 수 있도록 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//2. View에서 전송한 데이터를 받아 변수에 저장
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		//3. 비즈니스 로직 처리 (Controller -> Service -> DAO -> DB 처리후 리턴)
		Member m = new MemberService().selectOne(userId,userPwd);
		//4. 처리 결과에 따라 성공/실패 페이지 리턴
		if(m != null) {
			//로그인을 성공했다면? -> 세션 객체 생성하여 정보 저장
			if(m.getActivation().equals("Y")) {
				//비밀번호 변경여부를 true false로 받아옴
				boolean result = new MemberService().changePwdCheck(userId);
				
				HttpSession session = request.getSession();

				session.setAttribute("user", m);
				//비밀번호 변경일이 90일이 지났을경우
				if(result==true) {
					response.sendRedirect("/views/member/passwordChange.jsp");
				}else {
				// 로그인 성공 결과 페이지 전송
				response.sendRedirect("/views/member/success.jsp");
				}
			}
			else {
				//로그인 실패 결과 페이지 전송
				response.sendRedirect("/views/member/activationFail.jsp");
			}

			

		}
		else {
			response.sendRedirect("/views/member/fail.jsp");
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
