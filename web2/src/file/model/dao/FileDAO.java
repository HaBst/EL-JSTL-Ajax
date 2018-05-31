package file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.vo.DataFile;

public class FileDAO {

	public int uploadFile(Connection conn, DataFile df) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into fileTBL values(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, df.getFileName());
			pstmt.setString(2, df.getFilePath());
			pstmt.setLong(3, df.getFilesize());
			pstmt.setString(4, df.getFileUser());
			pstmt.setTimestamp(5, df.getUploadTime());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<DataFile> uploadList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<DataFile>list = null;
		
		String query = "select * from filetbl";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<DataFile>();
			while(rset.next()) {
				DataFile df = new DataFile();
				df.setFileName(rset.getString("filename"));
				df.setFilesize(rset.getLong("filesize"));
				df.setFileUser(rset.getString("fileuser"));
				df.setUploadTime(rset.getTimestamp("uploadtime"));
				list.add(df);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return list;
	}

}
