package join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import utility.DBClose;
import utility.DBOpen;

public class JoinDAO {
	
	public String getGrade(String id) {
		String grade = null;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("  select grade       ");
		sql.append("    from join     ");
		sql.append("   where id=?      ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				grade = rs.getString("grade");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return grade;
	}
	
	
	public String findPasswd(Map map) {
		String passwd = null;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String mname = (String)map.get("mname");
		String id = (String)map.get("id");
		
		StringBuffer sql = new StringBuffer();
		sql.append("   select passwd     ");
		sql.append("    from join    ");
		sql.append("   where mname=? and id=?     ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mname);
			pstmt.setString(2, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				passwd = rs.getString("passwd");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return passwd;
	}
	
	
	public String findID(Map map) {
		String id = null;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String mname = (String)map.get("mname");
		String tel = (String)map.get("tel");
		
		StringBuffer sql = new StringBuffer();
		sql.append("     select id     ");
		sql.append("    from join       ");
		sql.append("   where mname=? and tel=?       ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mname);
			pstmt.setString(2, tel);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
	
		return id;
	}
	
	public boolean delete(String id) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("  delete from join       ");
		sql.append("  where id = ?      ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0)flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt);
		}
	
		return flag;
	}
	
	
	public boolean loginCheck(Map map) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String id =(String)map.get("id");
		String pw = (String)map.get("pw");
		
		StringBuffer sql = new StringBuffer();
		sql.append("   select count(id) as cnt    ");
		sql.append("  from join     ");
		sql.append("   where id=? and passwd=?    ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			int cnt = rs.getInt("cnt");
			if(cnt>0)flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return flag;
	}
	
	
	
	public boolean update(JoinDTO dto) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("  update join      ");
		sql.append("  set       ");
		
		sql.append("   tel = ?,     ");
		sql.append("   address1 = ?,     ");
		sql.append("    address2 = ?    ");
		sql.append("   where id = ?           ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, dto.getTel());
			pstmt.setString(2, dto.getAddress1());
			pstmt.setString(3, dto.getAddress2());
			pstmt.setString(4, dto.getId());
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0)flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt);
		}
		
		return flag;
	}
	
	
	public boolean updatePw(Map map) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		
		String id = (String)map.get("id");
		String pw = (String)map.get("pw");
		
		StringBuffer sql = new StringBuffer();
		sql.append(" update join   ");
		sql.append(" set passwd=?   ");
		sql.append(" where id=?   ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0)flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt);
		}
		
		return flag;
	}
	
	
	public boolean updateFile(Map map) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		
		String id = (String)map.get("id");
		String fname = (String)map.get("fname");
		
		StringBuffer sql = new StringBuffer();
		sql.append("  update join        ");
		sql.append("    set fname = ?      ");
		sql.append("     where id=?     ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, fname);
			pstmt.setString(2, id);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0)flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt);
		}
	
		return flag;
	}
	
	public JoinDTO read(String id) {
		JoinDTO dto = null;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("   select id, mname, zipcode, address1, address2, tel, fname          ");
		sql.append("    from join         ");
		sql.append("   where id = ?          ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new JoinDTO();
				dto.setId(rs.getString("id"));
				dto.setMname(rs.getString("mname"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setAddress1(rs.getString("address1"));
				dto.setAddress2(rs.getString("address2"));
				dto.setTel(rs.getString("tel"));
				dto.setFname(rs.getString("fname"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		return dto;
	}
	
	
	public int total(Map map) {
		int total = 0;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String col = (String)map.get("col");
		String word = (String)map.get("word");
		
		StringBuffer sql = new StringBuffer();
		sql.append("   select count(*)     ");
		sql.append("    from join    ");
		if(word.length()>0) {
			sql.append("    where "+col+" like '%'| |?| |'%'    ");
		}
		
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			if(word.length()>0) {
			pstmt.setString(1, word);
			}
			rs = pstmt.executeQuery();
			
			rs.next();
			
			total = rs.getInt(1);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}		
		return total;
	}
	
	
	public List<JoinDTO> list(Map map){
		List<JoinDTO>list = new ArrayList<JoinDTO>();
		Connection con = DBOpen.open()	;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String col = (String)map.get("col");
		String word = (String)map.get("word");
		int sno = (Integer)map.get("sno");
		int eno = (Integer)map.get("eno");
		
		StringBuffer sql = new StringBuffer();
		sql.append("  select id, mname, zipcode, address1, address2, tel, fname, r        ");
		sql.append("  from(        ");
		sql.append("      select id, mname, zipcode, address1, address2, tel, fname, rownum r    ");
		sql.append("      from(    ");
		sql.append("       		 select id, mname, zipcode, address1, address2, tel, fname   ");
		sql.append("       		 from join   ");
		if(word.length()>0) {
			sql.append("     where  "+col+ "  like '%'| |?| |'%'      ");
		}
		sql.append("  order by rownum desc  ");
		
		sql.append("         )   ");
		sql.append("    )      ");
		sql.append("  where r>=? and r<=?       ");
		
		try {
			int i=0;
			pstmt = con.prepareStatement(sql.toString());
			if(word.length()>0) {
				pstmt.setString(++i, word);
			}
			pstmt.setInt(++i, sno);
			pstmt.setInt(++i, eno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				JoinDTO dto = new JoinDTO();
				dto.setId(rs.getString("id"));
				dto.setMname(rs.getString("mname"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setAddress1(rs.getString("address1"));
				dto.setAddress2(rs.getString("address2"));
				dto.setTel(rs.getString("tel"));
				dto.setFname(rs.getString("fname"));
				
				list.add(dto);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
    
		return list;
	}
	
	
	public boolean passCheck(Map map) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String id = (String)map.get("id");
		String passwd = (String)map.get("passwd");
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(passwd) as cnt           ");
		sql.append("   from join        ");
		sql.append("   where id=? and passwd=?         ");
		
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			int cnt = rs.getInt("cnt");
			
			if(cnt>0)flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return flag;
	}
	
	public boolean duplicatedTel(String tel) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(tel)   ");
		sql.append(" from join   ");
		sql.append(" where tel = ?   ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, tel);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			int cnt = rs.getInt(1);
			if(cnt>0)flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return flag;
	}
	
	
	public boolean duplicatedId(String id) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("     select count(id)          ");
		sql.append("     from join          ");
		sql.append("     where id= ?          ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			int cnt = rs.getInt(1);
			if(cnt>0)flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return flag;
	}
	
	
	public boolean create(JoinDTO dto) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("  insert into join(id, mname, zipcode, address1, address2, tel, fname, passwd)      ");
		sql.append("   values(?, ?, ?, ?, ?, ?, ?, ?)     ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getMname());
			pstmt.setString(3, dto.getZipcode());
			pstmt.setString(4, dto.getAddress1());
			pstmt.setString(5, dto.getAddress2());
			pstmt.setString(6, dto.getTel());
			pstmt.setString(7, dto.getFname());
			pstmt.setString(8, dto.getPasswd());
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0)flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt);
		}

		return flag;
	}

}
