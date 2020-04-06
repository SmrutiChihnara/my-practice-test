package com.nt.afp;

import com.nt.factory.DAOFactory;
import com.nt.factory.DBDAOFactory;
import com.nt.factory.ExcelDAOFactory;

public class DAOFactoryCreator {
	
	//Abstract Factory implementation....
	public static DAOFactory createDAOFactory(String storeType){
		 DAOFactory factory=null;
		if(storeType.equalsIgnoreCase("DB")){
			factory=new DBDAOFactory();
		}
		else if(storeType.equalsIgnoreCase("excel")){
			factory=new ExcelDAOFactory();
		}
		else{
			throw new IllegalArgumentException("Invalid strore type");
		}
		return factory;
	}//method
}//class
