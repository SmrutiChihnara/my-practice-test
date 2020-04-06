package com.nt.dto;

import java.io.Serializable;

public class PaymentDetails implements Serializable {
	private long cardNo;
	private int paymentGatewayCode;
	private int bankCode;
	private float amount;
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public int getPaymentGatewayCode() {
		return paymentGatewayCode;
	}
	public void setPaymentGatewayCode(int paymentGatewayCode) {
		this.paymentGatewayCode = paymentGatewayCode;
	}
	public int getBankCode() {
		return bankCode;
	}
	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

}
