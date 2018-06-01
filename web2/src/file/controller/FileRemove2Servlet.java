package file.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.model.service.FileService;
import file.model.vo.DataFile2;

/**
 * Servlet implementation class FileRemove2Servlet
 */
@WebServlet(name = "FileRemove2", urlPatterns = { "/fileRemove2" })
public class FileRemove2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileRemove2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 삭제시 진행해야 되는 것
		//1. DB 정보삭제
		//	- 비즈니스 로직처리(DELETE)
		//2. 실제 디렉토리에서 실제 파일을 삭제
		//	- a. 경로를 DB에서 알아 온 후 삭제
		//	- b. 경로가 항상 같다면 해당되는 디렉토리를 정적으로 명시하여 삭제
		
		
		
		//1. 인코딩처리
		request.setCharacterEncoding("utf-8");
		//2. 인자값 저장
		String afterFileName = request.getParameter("afterFileName");
//		System.out.println(afterFileName);
		
		// DB에서 해당 파일의 정보를 가져옴
		
		DataFile2 df2 = new FileService().fileSelect2Download(afterFileName);
		
		// DB에서 해당 파일의 정보를 삭제
		int result = new FileService().fileDelete2(afterFileName);
		
		if(result > 0) {
			File file = new File(df2.getFilePath());
			// 삭제는 delete 메소드를 사용하여 삭제
			file.delete();
			response.sendRedirect("/fileList2");
		}else {
			response.sendRedirect("/veiws/file/fileError.html");
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
