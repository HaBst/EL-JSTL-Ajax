package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;

public class MemberDAO {

	public Member selectOne(Connection conn, String userId, String userPwd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		
		String query = "select * from member where userId = ? and userPwd = ?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
			m = new Member();
			m.setUserId(rset.getString("userid"));
			m.setUserPwd(rset.getString("userpwd"));
			m.setUserName(rset.getString("username"));
			m.setUserAge(rset.getInt("age"));
			m.setUserEmail(rset.getString("email"));
			m.setUserPhone(rset.getString("phone"));
			m.setUserAddr(rset.getString("address"));
			m.setUserGender(rset.getString("gender"));
			m.setUserHobby(rset.getString("hobby"));
			m.setEnrolldate(rset.getDate("enrolldate"));
			m.setActivation(rset.getString("activation"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	}

	public ArrayList<Member> searchAll(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		
		ArrayList<Member>list = null;
		
		String query = "select * from member";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Member>();
			while(rset.next()) {
				Member m = new Member();
				m.setUserId(rset.getString("userid"));
				m.setUserName(rset.getString("username"));
				m.setUserAge(rset.getInt("age"));
				m.setUserEmail(rset.getString("email"));
				m.setUserPhone(rset.getString("phone"));
				m.setUserAddr(rset.getString("address"));
				m.setUserGender(rset.getString("gender"));
				m.setUserHobby(rset.getString("hobby"));
				m.setEnrolldate(rset.getDate("enrolldate"));
				m.setActivation(rset.getString("activation"));
				
				list.add(m);
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

	public int memberActivation(Connection conn, String userId, String memberActivation) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update member set activation = ? where userid = ?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberActivation);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}JDBCTemplate.close(pstmt);
				
				
		return result;
	}

	public int memberInsert(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into member values (?,?,?,?,?,?,?,?,?,sysdate,'Y')";
		
		try {			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setInt(4,m.getUserAge());
			pstmt.setString(5, m.getUserEmail());
			pstmt.setString(6, m.getUserPhone());
			pstmt.setString(7, m.getUserAddr());
			pstmt.setString(8, m.getUserGender());
			pstmt.setString(9, m.getUserHobby());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}

	public int memberUpdate(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update member set userpwd=?, email=?, phone=?, address=?, hobby=?"
				+ "where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getUserEmail());
			pstmt.setString(3, m.getUserPhone());
			pstmt.setString(4, m.getUserAddr());
			pstmt.setString(5, m.getUserHobby());
			pstmt.setString(6, m.getUserId());
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
				
		return result;
	}

	public int memberDelete(Connection conn,String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from member where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			
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
