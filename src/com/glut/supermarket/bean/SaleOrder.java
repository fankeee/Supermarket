package com.glut.supermarket.bean;

import java.util.Date;

/**
 * ��Ʒ���۵�
 * 
 * @author Fk
 *
 */
public class SaleOrder {

	// S_id ���۵���� int
	private int s_id;
	// S_totalAmount �ܽ�� float
	private float s_totalAmount;
	// S_saleDate ����ʱ�� date
	private Date s_saleDate;
	// U_id ����Ա��� int
	private int u_id;

	/**
	 * �޲ι��췽��
	 */
	public SaleOrder() {
		super();
	}

	/**
	 * �вι��췽��
	 * 
	 * @param s_id
	 * @param s_totalAmount
	 * @param s_saleDate
	 * @param u_id
	 */
	public SaleOrder(int s_id, float s_totalAmount, Date s_saleDate, int u_id) {
		super();
		this.s_id = s_id;
		this.s_totalAmount = s_totalAmount;
		this.s_saleDate = s_saleDate;
		this.u_id = u_id;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public float getS_totalAmount() {
		return s_totalAmount;
	}

	public void setS_totalAmount(float s_totalAmount) {
		this.s_totalAmount = s_totalAmount;
	}

	public Date getS_saleDate() {
		return s_saleDate;
	}

	public void setS_saleDate(Date s_saleDate) {
		this.s_saleDate = s_saleDate;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	@Override
	public String toString() {
		return "SaleOrder [s_id=" + s_id + ", s_totalAmount=" + s_totalAmount + ", s_saleDate=" + s_saleDate + ", u_id="
				+ u_id + "]";
	}

}
