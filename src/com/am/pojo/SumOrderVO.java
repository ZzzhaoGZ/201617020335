package com.am.pojo;

import java.math.BigDecimal;

public class SumOrderVO {

	private String itemname;

	private BigDecimal itemnum;

	private BigDecimal itemcurrency;

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public BigDecimal getItemnum() {
		return itemnum;
	}

	public void setItemnum(BigDecimal itemnum) {
		this.itemnum = itemnum;
	}

	public BigDecimal getItemcurrency() {
		return itemcurrency;
	}

	public void setItemcurrency(BigDecimal itemcurrency) {
		this.itemcurrency = itemcurrency;
	}

}
