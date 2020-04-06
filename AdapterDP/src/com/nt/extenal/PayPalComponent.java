package com.nt.extenal;

import com.nt.dto.PaymentDetails;

public class PayPalComponent {
	private static PayPalComponent instance;
	private PayPalComponent(){
	  //no operations
	}
	
	public static PayPalComponent getInstance(){
		
	 if(instance==null){
		synchronized (PayPalComponent.class) {
			if(instance==null)
				instance=new PayPalComponent();
		}
	   }
		return instance;
	}
	
	
  public String doPayment(PaymentDetails dto){
    return dto.getCardNo()+" card getting payment of "+dto.getAmount()+" from bank code "+dto.getBankCode();	  
  }
}
