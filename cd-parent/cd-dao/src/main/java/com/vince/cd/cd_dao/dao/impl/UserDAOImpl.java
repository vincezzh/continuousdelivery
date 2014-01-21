package com.vince.cd.cd_dao.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.vince.cd.cd_dao.dao.UserDAO;
import com.vince.cd.cd_dao.dto.UserDTO;

public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jdbcTemplate;  
	  
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
        this.jdbcTemplate = jdbcTemplate;  
    }
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public UserDTO login(UserDTO userDTO) throws Exception {
		String sql = "select * from zuser where username=? and password=?";
		List<UserDTO> result = jdbcTemplate.query(sql, new Object[] { userDTO.getUsername(), userDTO.getPassword() }, new RowMapper() {
            @Override
            public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            	UserDTO userDTOFinal = new UserDTO();
            	userDTOFinal.setAccountId(rs.getInt("account_id"));
        		userDTOFinal.setUsername(rs.getString("username"));
                return userDTOFinal;
            }
        });
        
        if(result.size() == 0)
        	return null;
        else
        	return result.get(0);
	}

}
