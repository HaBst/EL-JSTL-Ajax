package jquery.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jquery.test.vo.User;

/**
 * Servlet implementation class Test6Servlet
 */
@WebServlet(name = "Test6", urlPatterns = { "/test6" })
public class Test6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test6Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("홍길동",20,"경기도")); // index 0
		list.add(new User("김말똥",30,"서울시")); // index 1
		list.add(new User("고길똥",40,"전라도")); // index 2
		list.add(new User("김지똥",50,"경상도")); // index 3
		list.add(new User("박혜똥",60,"강원도")); // index 4
		list.add(new User("류훈똥",70,"충청도")); // index 5
		list.add(new User("한알름",80,"제주도")); // index 6
		list.add(new User("김례진",90,"독도")); // index 7
		list.add(new User("곽령훈",10,"울릉도")); // index 8
		list.add(new User("김취섭",25,"평양")); // index 9
		
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값 저장
		int userIndex2 = Integer.parseInt(request.getParameter("userIndex2"));
		
		JSONArray resultArray = new JSONArray(); //JSONArray 객체
		// 여러명의 정보를 담을 객체가 필요하기 때문에 array로 만듦
		
		if(0<= (userIndex2-1) && (userIndex2-1) <=9) { // 0~9 (사용자 1~10)
			JSONObject result = new JSONObject();
			User user = list.get(userIndex2-1);
			
			result.put("name", user.getName());
			result.put("age", user.getAge());
			result.put("addr", user.getAddr());
			
			resultArray.add(result);
		}else { // 입력한 인덱스 번호의 회원 정보가 없을때
			for(User user : list) {
				JSONObject result = new JSONObject();				
				result.put("name", user.getName());
				result.put("age", user.getAge());
				result.put("addr", user.getAddr());
				resultArray.add(result);
			}
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(resultArray);
		
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
