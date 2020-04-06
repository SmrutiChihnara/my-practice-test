package com.nt.service;

import com.nt.adapter.PaymentAdapter;
import com.nt.dto.CustomerPaymentDetailsDTO;
import com.nt.extenal.PayPalComponent;

public class OnlineShoppingPayment {
	
	public String payAmount(CustomerPaymentDetailsDTO cpdDTO){
		String paymentMsg=null;
		PaymentAdapter adapter=null;
		//use Adapter
		adapter=new PaymentAdapter();
		paymentMsg=adapter.doPaymentUsingPayPalComp(cpdDTO);
		return paymentMsg;
	}

}
