package com.vince.cd.cd_dao.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.vince.cd.cd_dao.dao.UserDAO;
import com.vince.cd.cd_dao.dto.AccountDTO;
import com.vince.cd.cd_dao.dto.UserDTO;

public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jdbcTemplate;  
	  
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
        this.jdbcTemplate = jdbcTemplate;  
    }
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public UserDTO login(UserDTO userDTO) throws Exception {
		String sql = "select u.username, a.id from zuser u left join zaccount a on u.account_id = a.id where u.username=? and u.password=?";
		List<UserDTO> result = jdbcTemplate.query(sql, new Object[] { userDTO.getUsername(), userDTO.getPassword() }, new RowMapper() {
            @Override
            public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            	UserDTO userDTOFinal = new UserDTO();
        		userDTOFinal.setUsername(rs.getString("username"));
        		AccountDTO account = new AccountDTO();
        		account.setId(rs.getInt("id"));
        		userDTOFinal.setAccount(account);
                return userDTOFinal;
            }
        });
        
        if(result.size() == 0)
        	return null;
        else
        	return result.get(0);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public UserDTO getDetail(String username) throws Exception {
		String sql = "select u.*, a.* from zuser u left join zaccount a on u.account_id = a.id where u.username=?";
		List<UserDTO> result = jdbcTemplate.query(sql, new Object[] { username }, new RowMapper() {
            @Override
            public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            	UserDTO user = new UserDTO();
        		user.setUsername(rs.getString("username"));
        		user.setPassword(rs.getString("password"));
        		AccountDTO account = new AccountDTO();
        		account.setId(rs.getInt("id"));
        		account.setAmount(rs.getDouble("amount"));
        		user.setAccount(account);
                return user;
            }
        });
        
        if(result.size() == 0)
        	return null;
        else
        	return result.get(0);
	}

}
