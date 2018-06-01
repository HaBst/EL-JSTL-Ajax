package file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.vo.DataFile;
import file.model.vo.DataFile2;

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

	public DataFile fileSelectDownload(Connection conn, String fileName, Timestamp uploadTime) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		DataFile df = null;
		String query = "select * from fileTbl where fileName = ? and uploadTime = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileName);
			pstmt.setTimestamp(2, uploadTime);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				df = new DataFile();
				df.setFileName(rset.getString("filename"));
				df.setFilePath(rset.getString("filepath"));
				df.setFilesize(rset.getLong("filesize"));
				df.setFileUser(rset.getString("fileuser"));
				df.setUploadTime(rset.getTimestamp("uploadtime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return df;
	}

	public int upload2File(Connection conn, DataFile2 df2) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into filetbl2 values(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, df2.getBeforeFileName());
			pstmt.setString(2, df2.getAfterFileName());
			pstmt.setString(3, df2.getFilePath());
			pstmt.setLong(4, df2.getFileSize());
			pstmt.setString(5, df2.getFileUser());
			pstmt.setTimestamp(6, df2.getUploadTime());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<DataFile2> upload2List(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<DataFile2>list = null;
		
		String query = "select * from filetbl2";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<DataFile2>();
			while(rset.next()) {
				DataFile2 df2 = new DataFile2();
				df2.setBeforeFileName(rset.getString("beforefilename"));
				df2.setAfterFileName(rset.getString("afterfilename"));
				df2.setFilePath(rset.getString("filepath"));
				df2.setFileSize(rset.getLong("filesize"));
				df2.setFileUser(rset.getString("fileuser"));
				df2.setUploadTime(rset.getTimestamp("uploadtime"));
				list.add(df2);
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

	public DataFile2 fileSelect2Download(Connection conn, String afterFileName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		DataFile2 df2 = null;
		String query = "select * from fileTbl2 where afterfileName = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, afterFileName);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				df2 = new DataFile2();
				df2.setBeforeFileName(rset.getString("beforefilename"));
				df2.setAfterFileName(rset.getString("afterfilename"));
				df2.setFilePath(rset.getString("filepath"));
				df2.setFileSize(rset.getLong("filesize"));
				df2.setFileUser(rset.getString("fileuser"));
				df2.setUploadTime(rset.getTimestamp("uploadtime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return df2;
	}

	public int fileDelete(Connection conn, String fileName, Timestamp uploadTime) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String Query = "delete from filetbl where filename = ? and uploadtime = ?";
		
		try {
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, fileName);
			pstmt.setTimestamp(2, uploadTime);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int fileDelete2(Connection conn, String afterFileName) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String Query = "delete from filetbl2 where afterfilename = ?";
		
		try {
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, afterFileName);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
