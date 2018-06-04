package jquery.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import jquery.test.vo.User;

/**
 * Servlet implementation class Test5Servlet
 */
@WebServlet(name = "Test5", urlPatterns = { "/test5" })
public class Test5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("홍길동",20,"경기도"));
		list.add(new User("김말똥",30,"서울시"));
		list.add(new User("고길똥",40,"전라도"));
		list.add(new User("김지똥",50,"경상도"));
		list.add(new User("박혜똥",60,"강원도"));
		list.add(new User("류훈똥",70,"충청도"));
		list.add(new User("한알름",80,"제주도"));
		list.add(new User("김례진",90,"독도"));
		list.add(new User("곽령훈",10,"울릉도"));
		list.add(new User("김취섭",25,"평양"));
		
		request.setCharacterEncoding("utf-8");		
		int userIndex = Integer.parseInt(request.getParameter("userIndex"));
		
		User user = list.get(userIndex-1); // 리스트도 배열처럼 0부터 시작
		
		JSONObject result = new JSONObject(); //JSON 객체 생성
		//JSON 객체는 MAP 형태로 사용 (키,값)
		result.put("name", user.getName());
		result.put("age", user.getAge());
		result.put("addr", user.getAddr());
		
		response.setContentType("application/json");
		// json 객체를 전송하려면 타입을 변경해주어야 함
		
		response.setCharacterEncoding("utf-8"); // 인코딩 작업
		response.getWriter().print(result);
		
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
