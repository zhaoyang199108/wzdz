package com.wzdz.dto;

import java.util.Date;

public class InformationView {
	
	public String[] s;
	public Date createDate;//创建时间
	public String content;//内容
	public String title;//标题
	
	public String[] getS() {
		return s;
	}

	public void setS(String[] s) {
		this.s = s;
	}
	
}
