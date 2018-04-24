package com.glut.supermarket.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * ��Ʒ��Ϣ
 * 
 * @author Fk
 *
 */
public class Goods {

	// g_id ��Ʒ��� int
	private int g_id;
	// g_name ���� Varchar(50)
	private String g_name;
	// g_purchasePrice ���� float
	private float g_purchasePrice;
	// g_sellingPrice �ۼ� float
	private float g_sellingPrice;
	// g_unit ��λ Varchar(10)
	private String g_unit;
	// g_productionDate �������� date
	private Date g_productionDate;
	// g_shelfLife ��Ч�� Varchar(10)
	private String g_shelfLife;
	// g_inventory ����� int
	private int g_inventory;
	// Pro_id ��Ӧ�̱�� int
	private int Pro_id;
	// g_productionAddress ������ַ Varchar(30)
	private String g_productionAddress;
	// C_id ��Ʒ��� int
	private int C_id;

	public Goods() {
		super();
	}

	public Goods(int g_id, String g_name, float g_purchasePrice, float g_sellingPrice, String g_unit,
			Date g_productionDate, String g_shelfLife, int g_inventory, int pro_id, String g_productionAddress,
			int c_id) {
		super();
		this.g_id = g_id;
		this.g_name = g_name;
		this.g_purchasePrice = g_purchasePrice;
		this.g_sellingPrice = g_sellingPrice;
		this.g_unit = g_unit;
		this.g_productionDate = g_productionDate;
		this.g_shelfLife = g_shelfLife;
		this.g_inventory = g_inventory;
		Pro_id = pro_id;
		this.g_productionAddress = g_productionAddress;
		C_id = c_id;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public float getG_purchasePrice() {
		return g_purchasePrice;
	}

	public void setG_purchasePrice(float g_purchasePrice) {
		this.g_purchasePrice = g_purchasePrice;
	}

	public float getG_sellingPrice() {
		return g_sellingPrice;
	}

	public void setG_sellingPrice(float g_sellingPrice) {
		this.g_sellingPrice = g_sellingPrice;
	}

	public String getG_unit() {
		return g_unit;
	}

	public void setG_unit(String g_unit) {
		this.g_unit = g_unit;
	}

	public Date getG_productionDate() {
		return g_productionDate;
	}

	public void setG_productionDate(Date g_productionDate) {
		this.g_productionDate = g_productionDate;
	}

	public String getG_shelfLife() {
		return g_shelfLife;
	}

	public void setG_shelfLife(String g_shelfLife) {
		this.g_shelfLife = g_shelfLife;
	}

	public int getG_inventory() {
		return g_inventory;
	}

	public void setG_inventory(int g_inventory) {
		this.g_inventory = g_inventory;
	}

	public int getPro_id() {
		return Pro_id;
	}

	public void setPro_id(int pro_id) {
		Pro_id = pro_id;
	}

	public String getG_productionAddress() {
		return g_productionAddress;
	}

	public void setG_productionAddress(String g_productionAddress) {
		this.g_productionAddress = g_productionAddress;
	}

	public int getC_id() {
		return C_id;
	}

	public void setC_id(int c_id) {
		C_id = c_id;
	}

	@Override
	public String toString() {
		return "Goods [g_id=" + g_id + ", g_name=" + g_name + ", g_purchasePrice=" + g_purchasePrice
				+ ", g_sellingPrice=" + g_sellingPrice + ", g_unit=" + g_unit + ", g_productionDate=" + g_productionDate
				+ ", g_shelfLife=" + g_shelfLife + ", g_inventory=" + g_inventory + ", Pro_id=" + Pro_id
				+ ", g_productionAddress=" + g_productionAddress + ", C_id=" + C_id + "]";
	}

}
