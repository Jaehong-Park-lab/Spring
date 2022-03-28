package com.spring.dao;

import java.util.ArrayList;

import com.spring.dto.BoardDto;

public class BoardDao extends DBConn {
	
	/** 
	 * R : 게시글 상세보기 select
	 */
	public BoardDto select(String bid){
		BoardDto dto = new BoardDto();
		String sql = " select bid, btitle, bcontent, bhit,to_char(bdate,'yyyy/mm/dd') bdate "
				+ " from board where bid=?";
		
		try {
			pstmt = getPreparedStatement(sql);
			pstmt.setString(1, bid);			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {					
				dto.setBid(rs.getString(1));
				dto.setBtitle(rs.getString(2));
				dto.setBcontent(rs.getString(3));
				dto.setBhit(rs.getInt(4));
				dto.setBdate(rs.getString(5));		
			}
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return dto;
	}
	
	/** 
	 * R : 게시글 전체 select
	 */
	public ArrayList<BoardDto> select(){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		String sql = " select rownum rno, bid, btitle, bhit, to_char(bdate,'yyyy/mm/dd') bdate "
				+ " from (select bid, btitle, bhit, bdate from board "
				+ "        order by bdate desc)";
		
		try {
			pstmt = getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setRno(rs.getInt(1));
				dto.setBid(rs.getString(2));
				dto.setBtitle(rs.getString(3));
				dto.setBhit(rs.getInt(4));
				dto.setBdate(rs.getString(5));
				
				list.add(dto);
			}
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return list;
	}
	
	
	/** 
	 * C : 게시글 update
	 */
	public int update(BoardDto dto) {
		int result = 0;
		String sql = "update board set btitle=?, bcontent=? where bid=?";
		
		try {
			pstmt = getPreparedStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3, dto.getBid());
			
			result = pstmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 
	 * C : 게시글 조회수 update
	 */
	public void updateHit(String bid) {
		String sql = "update board set bhit = bhit+1 where bid=?";
		
		try {
			pstmt = getPreparedStatement(sql);
			pstmt.setString(1, bid);					
			pstmt.executeUpdate();
			
			/* close(); */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/** 
	 * C : 게시글 delete
	 */
	public int delete(String bid) {
		int result = 0;
		String sql = "delete from board where bid=?";
		
		try {
			pstmt = getPreparedStatement(sql);
			pstmt.setString(1, bid);
					
			result = pstmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/** 
	 * C : 게시글 insert
	 */
	public int insert(BoardDto dto) {
		int result = 0;
		String sql = "INSERT INTO BOARD VALUES('b_'||SEQU_BOARD_BID.nextval,?,?,0,sysdate)";
		
		try {
			pstmt = getPreparedStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			
			result = pstmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
