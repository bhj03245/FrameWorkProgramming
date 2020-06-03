package org.kpu.di.persistence;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.kpu.di.domain.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public StudentVO read(String id) throws Exception {
	
		StudentVO vo = null;
		try {
			vo = jdbcTemplate.queryForObject( 
				     "SELECT * FROM STUDENT WHERE ID=?"
		             , new BeanPropertyRowMapper<StudentVO>(StudentVO.class), id);
		}
		catch(EmptyResultDataAccessException e) {
			return vo;
		}
		return vo;   
	}
	
	// RoWMapper 인터페이스를 구현한 익명 클래스를 정의, 클래스내 mapRow() 추상 메서드를 정의 
	public List<StudentVO> readList() throws Exception {
		List<StudentVO> studentlist = jdbcTemplate.query( 
		     "SELECT * FROM STUDENT", 
		     	new RowMapper<StudentVO>() {
		    	 	public StudentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	 		StudentVO vo = new StudentVO();
		    	 		vo.setId(rs.getString("ID"));
		    	 		vo.setPasswd(rs.getString("PASSWD"));
		    	 		vo.setUsername(rs.getString("USERNAME"));
		    	 		vo.setSnum(rs.getString("SNUM"));
		    	 		vo.setDepart(rs.getString("DEPART"));
		    	 		vo.setMobile(rs.getString("MOBILE"));
		    	 		vo.setEmail(rs.getString("EMAIL"));
		    	 		return vo;
		    	 	}
             	}
		);
		return studentlist;
	}
	
	public void add(StudentVO vo) throws Exception {
		jdbcTemplate.update(
			"INSERT INTO STUDENT (ID, PASSWD, USERNAME, SNUM, DEPART, MOBILE, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?)"
			, vo.getId(), vo.getPasswd(), vo.getUsername(), vo.getSnum(), vo.getDepart(), vo.getMobile(), vo.getEmail());
	}
	
	public void update(StudentVO vo) throws Exception {
		String sql = "UPDATE STUDENT set " + "PASSWD = ?, USERNAME = ?, SNUM = ?, DEPART = ?, MOBILE = ?, EMAIL = ? "
					 + "WHERE ID = ?";
		jdbcTemplate.update(sql,vo.getPasswd(), vo.getUsername(), vo.getSnum(), vo.getDepart(), vo.getMobile(), vo.getEmail(), vo.getId());
	}
	
	public void delete(String id) throws Exception {
		jdbcTemplate.update("DELETE FROM STUDENT WHERE ID = ?", id);
	}
}
