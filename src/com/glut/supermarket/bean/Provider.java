package com.glut.supermarket.bean;

/**
 * ��Ӧ����Ϣ
 * 
 * @author Fk
 *
 */
public class Provider {

	// Pro_id ��Ӧ�̱�� int
	private int pro_id;
	// Pro_name ���� Varchar(20)
	private String pro_name;
	// Pro_address ��ַ Varchar(30)
	private String pro_address;
	// Pro_contactPerson ��ϵ�� Varchar(10)
	private String pro_contactPerson;
	// Pro_tel �绰 Varchar(11)
	private String pro_tel;
	// Pro_email E-mail Varchar(20)
	private String pro_email;

	public Provider() {
		super();
	}

	public Provider(int pro_id, String pro_name, String pro_address, String pro_contactPerson, String pro_tel,
			String pro_email) {
		super();
		this.pro_id = pro_id;
		this.pro_name = pro_name;
		this.pro_address = pro_address;
		this.pro_contactPerson = pro_contactPerson;
		this.pro_tel = pro_tel;
		this.pro_email = pro_email;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_address() {
		return pro_address;
	}

	public void setPro_address(String pro_address) {
		this.pro_address = pro_address;
	}

	public String getPro_contactPerson() {
		return pro_contactPerson;
	}

	public void setPro_contactPerson(String pro_contactPerson) {
		this.pro_contactPerson = pro_contactPerson;
	}

	public String getPro_tel() {
		return pro_tel;
	}

	public void setPro_tel(String pro_tel) {
		this.pro_tel = pro_tel;
	}

	public String getPro_email() {
		return pro_email;
	}

	public void setPro_email(String pro_email) {
		this.pro_email = pro_email;
	}

	@Override
	public String toString() {
		return "Provider [pro_id=" + pro_id + ", pro_name=" + pro_name + ", pro_address=" + pro_address
				+ ", pro_contactPerson=" + pro_contactPerson + ", pro_tel=" + pro_tel + ", pro_email=" + pro_email
				+ "]";
	}

}
