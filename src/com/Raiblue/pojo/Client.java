package com.Raiblue.pojo;

public class Client {
	private int ID;
	private String numberid;
	private String name;
	private String sex;
	private String vipgrade;
	private String phone;
	private String indate;
	private String outdate;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getOutdate() {
		return outdate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	public String getNumberid() {
		return numberid;
	}
	public void setNumberid(String numberid) {
		this.numberid = numberid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getVipgrade() {
		return vipgrade;
	}
	public void setVipgrade(String vipgrade) {
		this.vipgrade = vipgrade;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Client [ID=" + ID + " ,numberid=" + numberid + ", name=" + name + ", sex="
				+ sex + ", vipgrade=" + vipgrade + ", phone=" + phone
				+ ", indate=" + indate + ", outdate=" + outdate + "]";
	}
	
	
}
