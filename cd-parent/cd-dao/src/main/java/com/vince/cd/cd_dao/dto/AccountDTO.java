package com.vince.cd.cd_dao.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class AccountDTO {
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
		if (obj != null && obj instanceof AccountDTO) {
			AccountDTO user = (AccountDTO) obj;
            return new EqualsBuilder().append(getId(), user.getId())
            							.isEquals();
        }
        return false;
    }
}
