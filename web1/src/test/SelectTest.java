package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectTest
 */
@WebServlet(name = "Select", urlPatterns = { "/select" })
public class SelectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String [] arr = new String[] {};
		// String형태의 배열을 생성
		arr = request.getParameterValues("nol");
		// name이 nol인 input의 value를 arr에 저장
		
		System.out.println(arr[0].toString());
		// 출력 테스트
		response.setContentType("text/html; charset = utf-8");
		// 출력 인ㅋ딩
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>결과</title></head>");
		out.println("<body>");
		out.println("<h1>당신이 선택한 관광지 입니다.</h1>");
		out.println("<hr>");
		for(int i = 0; i < arr.length; i++) {
			out.println(arr[i].toString());
		}
		out.println("<body>");
		out.println("<html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
