package com.chinawanbang.casecollection.system.entity;

public class Person {
	
	private String trueName;
	private String hospital;
	private String openId;
	private int id;
	private String portrait;
	private String pptUrl;
	public String getPptUrl() {
		return pptUrl;
	}
	public void setPptUrl(String pptUrl) {
		this.pptUrl = "https://fyhcollection.oss-cn-hangzhou.aliyuncs.com/ppt/"+pptUrl;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

}