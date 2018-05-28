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
 * Servlet implementation class DeleteServlet
 */
@WebServlet(name = "Delete", urlPatterns = { "/delete" })
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값 꺼내기(다시 입력한 비밀번호 값)
		String userPwd = request.getParameter("userPwd");
		
		HttpSession session = request.getSession(false);
		int result = 0;
		
		result = new MemberService().memberDelete(((Member)session.getAttribute("user")).getUserId(),userPwd);
		
		if(result > 0) {
			session.invalidate(); // 세션 파기
			// 회원 탈퇴후에는 해당 계정을 더이상 사용하지 못하게
			// 회원 정보 삭제 및 세션 파기 작업을 해야 함
			response.sendRedirect("/views/member/deleteSuccess.jsp");
		}else {
			response.sendRedirect("/views/member/deleteFail.jsp");
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
