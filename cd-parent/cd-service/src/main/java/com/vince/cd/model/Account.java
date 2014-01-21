package com.vince.cd.model;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Account {
	private Integer id;
	private Double amount;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
    public boolean equals(Object obj) {
		if (obj != null && obj instanceof Account) {
            Account user = (Account) obj;
            return new EqualsBuilder().append(getId(), user.getId())
            							.isEquals();
        }
        return false;
    }
}
