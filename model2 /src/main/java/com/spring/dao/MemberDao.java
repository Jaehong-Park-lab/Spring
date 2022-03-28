package com.spring.dao;

import java.util.ArrayList;

import com.spring.dto.MemberDto;

public class MemberDao extends DBConn{
	
	/**
	 * R(Select) : 회원리스트 select 
	 */
	public ArrayList<MemberDto> select(){
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		String sql = " select rownum rno,id, name, email, hp_num, hobby "
				+ " from (select id, name, email, hp_num, hobby "
				+ "        from member  order by id) ";
		
		try {
			pstmt = getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setRno(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setHp_num(rs.getString(5));
				dto.setHobby(rs.getString(6));
				
				list.add(dto);
			}
			
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return list;
	}
	
	
	
	/**
	 * R(Select) : 로그인 처리 select 
	 */
	public int select(MemberDto dto) {
		int result = 0;
		String sql = "SELECT COUNT(id) FROM MEMBER WHERE ID=? and pass=?";
		
		try {
			pstmt = getPreparedStatement(sql);			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			
			rs = pstmt.executeQuery();	//select--> executeQuery || insert, update, delete --> executeUpdate
			while(rs.next()) {
				result = rs.getInt(1);
			}
			
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/**
	 * C(Insert) : 회원데이터 insert
	 */
	public int insert(MemberDto dto) {
		int result = 0;
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,? )";
		
		try {
			pstmt = getPreparedStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getAddress());
			pstmt.setString(7, dto.getTel());
			pstmt.setString(8, dto.getHp_num());
			pstmt.setString(9, dto.getHobby());
			pstmt.setString(10, dto.getIntro());	
			
			result = pstmt.executeUpdate();
			
			close();	
				
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return result;		
	}
}
