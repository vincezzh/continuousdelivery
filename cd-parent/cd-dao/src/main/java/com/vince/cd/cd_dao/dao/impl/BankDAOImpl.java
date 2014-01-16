package com.vince.cd.cd_dao.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.vince.cd.cd_dao.dao.BankDAO;
import com.vince.cd.cd_dao.dto.UserDTO;

public class BankDAOImpl implements BankDAO {
	private JdbcTemplate jdbcTemplate;  
	  
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
        this.jdbcTemplate = jdbcTemplate;  
    }
    
	@Override
	public double deposit(double money) throws Exception {
//		String sql = "insert into products (id, price, description) values (?,?,?)";  
//        jdbcTemplate.update(sql, new Object[] { prod.getId(), prod.getPrice(),  
//                prod.getDescription() });
		return 0;
	}

	@Override
	public double withdraw(double money) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBalance(int accountNumber) throws Exception {
		// TODO Auto-generated method stub
		return 0;
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
