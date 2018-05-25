package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		// 서블릿에서 데이터를 처리할때에는 크게 4가지를 꼭 진행 해야 함
		// 1. 전송값의 한글이 있는 경우 인코딩 처리
		request.setCharacterEncoding("utf-8");
		// 2. 웹에서 보내준 전송값을 꺼내어 변수에 저장 (request)
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		System.out.println(userId+"/"+userPwd);
		// 3. 비즈니스 로직 작동 (Model 작업)
		Member m = new MemberService().selectMember(userId,userPwd);
		
		//	System.out.println(m.getMemberName());
		// 4. 처리 완료후 결과 응답 (response)
		response.setContentType("text/html; charset = UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>로그인 성공/실패 여부</title></head>");
		out.println("<body>");
		
		if(m != null)//로그인 성공했다면
		{
			HttpSession session = request.getSession(); // Session 객체를 가져옴 (생성)
			
			session.setAttribute("user", m);
			
			out.println("<H1>로그인에 성공 하셨습니다</H1>");
			out.println("<H1>"+m.getMemberId()+"</H1>님 환영합니다");
			out.println("<a href=myInfo>마이페이지</a> ");
			out.println("<a href=logout>로그아웃</a>");
	
		}
		else //로그인에 실패했다면
		{
			out.println("<H1>로그인에 실패 하였습니다.</H1>");
			out.println("<H1>ID 또는 Password를 확인하세요</H1>");
		}
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
