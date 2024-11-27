package edu.pnu.dao;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import edu.pnu.domain.MemberDTO;

public class MemberDAO extends JDBConnect{

	public List<MemberDTO> getAllMember() {
		
		List<MemberDTO> list = new Vector<MemberDTO>();
		String query = "SELECT * FROM member ";
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

            while (rs.next()) {
            	MemberDTO dto = new MemberDTO();

                dto.setId(rs.getInt("id"));
                dto.setPass(rs.getString("pass"));
                dto.setName(rs.getString("name"));
                dto.setRegidate(rs.getDate("regidate"));
                list.add(dto);
            }
        }
        catch (Exception e) {
            System.out.println("게시물 조회 중 예외 발생");
            e.printStackTrace();
        }
        return list;
	}

	public MemberDTO getMemberById(Integer id) {
		
		MemberDTO dto = null;
		String query = "SELECT id, name FROM member WHERE id=?";
		try {
			psmt = con.prepareStatement(query);
            psmt.setInt(1, id);  
			rs = psmt.executeQuery();

            while (rs.next()) {
            	dto = new MemberDTO();

                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
            }
        }
        catch (Exception e) {
            System.out.println("게시물 조회 중 예외 발생");
            e.printStackTrace();
        }
        return dto;
	}

	public MemberDTO addMember(MemberDTO memberVO) {
		MemberDTO dto = null;  

        try {
        	String query= "INSERT INTO member (id, pass, name)"
        			 + " VALUES (?, ?, ?)";
            psmt = con.prepareStatement(query);
            psmt.setInt(1, memberVO.getId());
            psmt.setString(2, memberVO.getPass());
            psmt.setString(3, memberVO.getName());
            psmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("회원 추가 중 예외 발생");
            e.printStackTrace();
        }
        return dto;
	}

	public int updateMember(MemberDTO memberVO) {
		int result = 0;
        try {
            String query = "UPDATE member"
                         + " SET pass=?, name=?"
                         + "WHERE id = ?";

            psmt = con.prepareStatement(query);
            psmt.setString(1, memberVO.getPass());
            psmt.setString(2, memberVO.getName());
            psmt.setInt(3, memberVO.getId());

            result = psmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("정보 수정 중 예외 발생");
            e.printStackTrace();
        }
        return result;
	}

	public int removeMember(Integer id) {
        int result = 0;
        try {
            String query = "DELETE FROM member WHERE id=?";
            psmt = con.prepareStatement(query);
            psmt.setInt(1, id);
            result = psmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("회원정보 삭제 중 예외 발생");
            e.printStackTrace();
        }
        return result;
	}
}
