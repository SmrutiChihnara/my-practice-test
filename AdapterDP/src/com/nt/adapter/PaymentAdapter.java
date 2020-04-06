package com.nt.adapter;

import com.nt.dto.CustomerPaymentDetailsDTO;
import com.nt.dto.PaymentDetails;
import com.nt.extenal.PayPalComponent;

public class PaymentAdapter {
	
	
	public String doPaymentUsingPayPalComp(CustomerPaymentDetailsDTO cpdDTO){
		 int paymentGatewayCode=0;
		 int bankCode=0;
		 PaymentDetails dto=null;
		 PayPalComponent extComp=null;
		 String paymentMsg=null;
		 //get PaymentGateway code
		if(cpdDTO.getPaymentGateWay().equals("VISA"))
          paymentGatewayCode=111;
        else  if(cpdDTO.getPaymentGateWay().equals("MASTER"))
          paymentGatewayCode=222;
       else  if(cpdDTO.getPaymentGateWay().equals("CIRRUS"))
           paymentGatewayCode=333;
       else
    	   throw new IllegalArgumentException("Invalid Payment Gateway");
         //get Bank code
		if(cpdDTO.getBankName().equalsIgnoreCase("SBI"))
			bankCode=1001;
		else if(cpdDTO.getBankName().equalsIgnoreCase("ICICI"))
			bankCode=1002;
		else if(cpdDTO.getBankName().equalsIgnoreCase("HDFC"))
			bankCode=1003;
		else
			throw new IllegalArgumentException("invalid bank name");
		
       //prepare PaymentDetails object
		dto=new PaymentDetails();
		dto.setCardNo(cpdDTO.getCardNo());
		dto.setBankCode(bankCode);
		dto.setPaymentGatewayCode(paymentGatewayCode);
		dto.setAmount(cpdDTO.getAmount());
	  //call Extenal Service
		extComp=PayPalComponent.getInstance();
		paymentMsg=extComp.doPayment(dto);
		return paymentMsg;
	}//method
   }//class
