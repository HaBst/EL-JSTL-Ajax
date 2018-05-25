package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet(name = "Cal", urlPatterns = { "/cal" })
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int first = Integer.parseInt(request.getParameter("firstValue"));
		int second = Integer.parseInt(request.getParameter("secondValue"));
		
		String val = request.getParameter("cal");
		
		System.out.println(val);
		
		
		
		response.setContentType("text/html; charset = UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>결과출력</title></head>");
		out.println("<body>");
		switch(val)
		{
		case "+" : out.println(first+"+"+second+"="+(first+second)); break;
		case "-" : out.println(first+"-"+second+"="+(first-second)); break;
		case "*" : out.println(first+"*"+second+"="+(first*second)); break;
		case "/" : out.println(first+"/"+second+"="+(first/second)); break;
		}
		out.println("</body>");
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
