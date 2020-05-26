package com.sai.RestApi;

import javax.xml.bind.annotation.XmlRootElement;

 @XmlRootElement
 public class Alien {
	private int aid;
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", atech=" + atech + "]";
	}
	private String aname;
	private  String atech;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAtech() {
		return atech;
	}
	public void setAtech(String atech) {
		this.atech = atech;
	}
	

}
