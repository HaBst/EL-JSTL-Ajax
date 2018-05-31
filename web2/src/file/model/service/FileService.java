package file.model.service;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.dao.FileDAO;
import file.model.vo.DataFile;

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

}
