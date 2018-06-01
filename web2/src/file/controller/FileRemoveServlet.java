package file.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.model.service.FileService;
import file.model.vo.DataFile;

/**
 * Servlet implementation class FileRemoveServlet
 */
@WebServlet(name = "FileRemove", urlPatterns = { "/fileRemove" })
public class FileRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileRemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String fileName = request.getParameter("fileName");
		Timestamp uploadTime = Timestamp.valueOf(request.getParameter("uploadTime"));

		DataFile df = new FileService().fileSelectDownload(fileName,uploadTime);
		
		
		if(df != null) {
	
			int result = new FileService().fileDelete(fileName,uploadTime);
			if(result > 0) {
				File file = new File(df.getFilePath());
				file.delete();
				response.sendRedirect("views/file/fileDeleteSuccess.jsp");
			}
		}else {

			response.sendRedirect("views/file/fileError.html");
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
