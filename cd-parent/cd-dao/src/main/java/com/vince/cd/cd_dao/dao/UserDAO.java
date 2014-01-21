package com.vince.cd.cd_dao.dao;

import com.vince.cd.cd_dao.dto.UserDTO;

public interface UserDAO {
	UserDTO login(UserDTO userDTO) throws Exception;
	UserDTO getDetail(String username) throws Exception;
}
