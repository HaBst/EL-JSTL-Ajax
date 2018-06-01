package file.model.service;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.dao.FileDAO;
import file.model.vo.DataFile;
import file.model.vo.DataFile2;

public class FileService {

	public int uploadFile(DataFile df) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FileDAO().uploadFile(conn,df);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.connclose(conn);
		
		return result;
	}

	public ArrayList<DataFile> uploadList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<DataFile>list = null;
		
		list = new FileDAO().uploadList(conn);
		
		JDBCTemplate.connclose(conn);
		
		return list;		
	}

	public DataFile fileSelectDownload(String fileName, Timestamp uploadTime) {
		Connection conn = JDBCTemplate.getConnection();

		DataFile df = new FileDAO().fileSelectDownload(conn,fileName,uploadTime);
		
		JDBCTemplate.connclose(conn);
		
		return df;
		
	}

	public int upload2File(DataFile2 df2) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FileDAO().upload2File(conn,df2);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.connclose(conn);
		
		return result;
	}

	public ArrayList<DataFile2> upload2List() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<DataFile2>list = null;
		
		list = new FileDAO().upload2List(conn);
		
		JDBCTemplate.connclose(conn);
		
		return list;
	}

	public DataFile2 fileSelect2Download(String afterFileName) {
		Connection conn = JDBCTemplate.getConnection();

		DataFile2 df2 = new FileDAO().fileSelect2Download(conn,afterFileName);
		
		JDBCTemplate.connclose(conn);
		
		return df2;
	}

	public int fileDelete(String fileName, Timestamp uploadTime) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FileDAO().fileDelete(conn,fileName,uploadTime);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.connclose(conn);

		return result;
	}

	public int fileDelete2(String afterFileName) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FileDAO().fileDelete2(conn,afterFileName);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.connclose(conn);

		return result;
		
	}

}
