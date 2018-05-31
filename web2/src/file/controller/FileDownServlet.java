package file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.model.service.FileService;
import file.model.vo.DataFile;

/**
 * Servlet implementation class FileDownServlet
 */
@WebServlet(name = "FileDown", urlPatterns = { "/fileDown" })
public class FileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileDownServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 셋팅
		request.setCharacterEncoding("utf-8");

		// 파일 다운로드를 받기 위하여 정보 2가지
		String fileName = request.getParameter("fileName");
		Timestamp uploadTime = Timestamp.valueOf(request.getParameter("uploadTime"));
//		System.out.println(uploadTime);
//		System.out.println(fileName);
		DataFile df = new FileService().fileSelectDownload(fileName,uploadTime);
//		System.out.println(df.getFileName());

		if(df !=null) {
			// 해당 파일을 열람
			File file = new File(df.getFilePath());

			// 파일 이름을 운영체제(windows)에 맞게 인코딩 해주어야 함
			// ISO-8859-1 -> windows에서 사용하는 인코딩
			String encFileName = new String(df.getFileName().getBytes(),"ISO-8859-1");

			// 파일의 내용을 전송시에는 response 헤더를 변경해주어야 함
			// 파일을 다운받을때는 항상 바꿔주어야함
			response.setContentType("application/octet-stream");
			response.setContentLengthLong(file.length());
			response.setHeader("content-Disposition", "attachment;filename="+encFileName);

			// 파일의 내용을 읽어와야 전송하기 때문에 내용을 가져올 수 있는 inputStream을 가져옴
			FileInputStream fileIn = new FileInputStream(file);

			// 파일의 내용을 클라이언트한테 전송하기 위하여
			// response 객체를 이용하여 outputStream을 가져옴
			ServletOutputStream out = response.getOutputStream();

			byte[] outputByte = new byte[4096];
			// 4096 -> 클러스터 사이즈(한번에 처리하는 데이터 량)
			while(fileIn.read(outputByte,0,4096)!=-1) {//읽을게 없으면 -1이 리턴됨
				out.write(outputByte,0,4096);
			}
			fileIn.close();
			out.close();
		}
		else {
			response.sendRedirect("veiws/file/fileErroe.html");
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
