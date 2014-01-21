package com.vince.cd.cd_dao.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;


public class UserDTO {
	private String username;
	private String password;
	private AccountDTO account;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AccountDTO getAccount() {
		return account;
	}
	public void setAccount(AccountDTO account) {
		this.account = account;
	}
	
	@Override
    public boolean equals(Object obj) {
		if (obj != null && obj instanceof UserDTO) {
			UserDTO user = (UserDTO) obj;
            return new EqualsBuilder().append(getUsername(), user.getUsername())
            							.isEquals();
        }
        return false;
    }
}
