package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RadioTest
 */
@WebServlet(name = "Radio", urlPatterns = { "/radio" })
public class RadioTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RadioTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String text = request.getParameter("text");
		
		System.out.println(gender);
		System.out.println(email);
		System.out.println(text);
		
		response.setContentType("text/html; charset = utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>결과</title></head>");
		out.println("<body>");
		out.println("<h1>클라이언트의 입력 정보</h1>");
		out.println("<hr>");
		out.println("<h3>");
		out.println("성별 : "+gender+"<br><br>");
		out.println("메인 수신 여부 : "+email+"<br><br>");
		out.println("가입 인사 : "+text+"<br><br>");
		out.println("</h3><html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
