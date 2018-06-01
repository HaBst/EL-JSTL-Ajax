package member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;

/**
 * Servlet implementation class EL_Test2Servlet
 */
@WebServlet(name = "EL_Test2", urlPatterns = { "/eL_Test2" })
public class EL_Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EL_Test2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("name", "홍길동");
//		map.put("age","20");
//		map.put("addr","경기도");
//		
//		RequestDispatcher view = request.getRequestDispatcher("/views/el/el_test2.jsp");
//		request.setAttribute("member", map);
//		view.forward(request, response);
		HashMap<String,Member> map = new HashMap<String,Member>();
		map.put("member1", new Member("홍길동",20,"경기도"));
		map.put("member2", new Member("김말똥",30,"서울시"));
		
		RequestDispatcher view = request.getRequestDispatcher("/views/el/el_test2.jsp");
		request.setAttribute("members", map);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
