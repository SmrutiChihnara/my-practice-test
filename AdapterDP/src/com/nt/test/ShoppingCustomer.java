package com.nt.test;

import com.nt.dto.CustomerPaymentDetailsDTO;
import com.nt.service.OnlineShoppingPayment;

public class ShoppingCustomer {

	public static void main(String[] args) {
		OnlineShoppingPayment shopping=null;
		CustomerPaymentDetailsDTO cpdDTO=null;
		String reciept;
		//create ShoppingPayment
		shopping=new OnlineShoppingPayment();
		//prepare CustomerPaymentDetailsDTO
		cpdDTO=new CustomerPaymentDetailsDTO();
		cpdDTO.setCardNo(11123433);
		cpdDTO.setBankName("ICICI");
		cpdDTO.setPaymentGateWay("VISA");
		cpdDTO.setAmount(9000);
	   //do Payment
		reciept=shopping.payAmount(cpdDTO);
        System.out.println(reciept);
	}//main
}//class
