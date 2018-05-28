package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public Member selectOne(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = null;
		
		m = new MemberDAO().selectOne(conn,userId,userPwd);
		JDBCTemplate.connclose(conn);
		return m;
	}

	public ArrayList<Member> searchAll() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = null;
		
		list = new MemberDAO().searchAll(conn);
		JDBCTemplate.connclose(conn);
		return list;
	}

	public int memberActivation(String userId, String memberActivation) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		result = new MemberDAO().memberActivation(conn,userId,memberActivation);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.connclose(conn);
		
		
		return result;
	}

	public int memberInsert(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		result = new MemberDAO().memberInsert(conn,m);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.connclose(conn);
		
		return result;
	}

	public int memberUpdate(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		result = new MemberDAO().memberUpdate(conn,m);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.connclose(conn);
		
		return result;
	}

	public int memberDelete(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		
		result = new MemberDAO().memberDelete(conn,userId);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.connclose(conn);
		
		return result;
	}


	

}
