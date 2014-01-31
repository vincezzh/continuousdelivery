package com.cd.view.controller.vo;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.vince.cd.model.User;

public class UserVO {
	private String username;
	private String password;
	private AccountVO account;
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
	public AccountVO getAccount() {
		return account;
	}
	public void setAccount(AccountVO account) {
		this.account = account;
	}

	@Override
    public boolean equals(Object obj) {
		if (obj != null && obj instanceof User) {
			UserVO user = (UserVO) obj;
            return new EqualsBuilder().append(getUsername(), user.getUsername())
            							.isEquals();
        }
        return false;
    }
}
