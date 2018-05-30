package file.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.model.vo.Member;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(name = "Upload", urlPatterns = { "/upload" })
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드르르 거ㅜ현하려면 몇가지 정보들이 필요함
		//1. 사용자 계정명(업로드한 사람 정보가 있어야함, session객체에서 꺼냄)
		HttpSession session = request.getSession();
		
		String userId = (((Member)session.getAttribute("user")).getUserId());
		
		//2. 최대 업로드 파일 사이즈 (설정)
		int fileSizeLimit = 1024*1024*5;//Byte 단위(5MB)
		
		//3. 업로드 될 경로
		String uploadFilePath = getServletContext().getRealPath("/")+"uploadfile"; // getRealPath("/")-> WebContent
		
		//4. 인코딩 타입(파일 인코딩 타입)
		String enctype = "UTF-8";
		
		// 위에 정보를 바탕으로
		//5. MultipartRequest 객체를 생성
		//MultipartRequest 객체가 생성되면 requst의 기능 이 사라짐(MultipartRequest로 합쳐짐)
		//인자값 순서  : request, 파일경로, 파일최대 사이즈, 인코딩 타입, Policy
		
		MultipartRequest multi = new MultipartRequest(request,uploadFilePath,fileSizeLimit,enctype,new DefaultFileRenamePolicy());
		// 마지막 인자값인 DefaultFileRenamePolicy 객체를 생성하여
		// 넣어줌으로써 파일 중복 처리를 자동으로 해결함
		// ex) a.bmp가 중복으로 업로드 되면 a1.bmp, a2.bmp, a3.bmp....
		// MultipartRequest 객체가 생성되면 자동으로 파일은 해당 경로로
		// 업로드 됨
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
