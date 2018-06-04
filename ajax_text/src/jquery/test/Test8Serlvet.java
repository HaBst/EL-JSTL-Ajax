package jquery.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import jquery.test.vo.User;

/**
 * Servlet implementation class Test8Serlvet
 */
@WebServlet(name = "Test8", urlPatterns = { "/test8" })
public class Test8Serlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test8Serlvet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("홍길동",20,"경기도"));	// index 0
		list.add(new User("김말똥",30,"서울시")); 	// index 1
		list.add(new User("고길똥",40,"전라도")); 	// index 2
		list.add(new User("김지똥",50,"경상도")); 	// index 3
		list.add(new User("박혜똥",60,"강원도")); 	// index 4
		list.add(new User("류훈똥",70,"충청도")); 	// index 5
		list.add(new User("한알름",80,"제주도")); 	// index 6
		list.add(new User("김례진",90,"독도")); 	// index 7
		list.add(new User("곽령훈",10,"울릉도")); 	// index 8
		list.add(new User("김취섭",25,"평양")); 	// index 9

		request.setCharacterEncoding("utf-8");

		String userIndexs2 = request.getParameter("userIndexs2");

		StringTokenizer sT = new StringTokenizer(userIndexs2,",");

		// 토큰 확인 코드
		//		while(sT.hasMoreTokens()) {
		//			System.out.println(sT.nextToken());
		//		}
		//인덱스 번호를 저장
		ArrayList<Integer> userSelect = new ArrayList<Integer>();

		while(sT.hasMoreTokens()) {
			userSelect.add(Integer.parseInt(sT.nextToken())-1);
		}
		
		JSONObject resultMap = new JSONObject();
		// JSON객체 자체가 기본적으로 MAP 형태이기 때문에
		// 키 : 값 형태로 사용하면 됨
		
		int index = 0;
		
		while(index<userSelect.size()) {
			User user = list.get(userSelect.get(index));
			JSONObject result = new JSONObject();
			result.put("name", user.getName());
			result.put("age", user.getAge());
			result.put("addr", user.getAddr());
			
			resultMap.put(index, result);
			index++;
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(resultMap);
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
