package com.nt.test;

import com.nt.dao.DAO;
import com.nt.factory.DBDAOFactory;
import com.nt.factory.ExcelDAOFactory;

public class Client1 {

	public static void main(String[] args) {
		 DAO stDAO=null,courseDAO=null;
		 
		 stDAO=DBDAOFactory.getDAO("student");
		 stDAO.insert();
		 courseDAO=ExcelDAOFactory.getDAO("course");
		 courseDAO.insert();
	}//main
}//class
