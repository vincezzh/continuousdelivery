package com.vince.cd.model;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class User {
	private String username;
	private String password;
	private Account account;
	
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
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
    public boolean equals(Object obj) {
		if (obj != null && obj instanceof User) {
            User user = (User) obj;
            return new EqualsBuilder().append(getUsername(), user.getUsername())
            							.isEquals();
        }
        return false;
    }
}
