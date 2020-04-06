package com.nt.test;

import com.nt.dao.DAO;
import com.nt.factory.DBDAOFactory;
import com.nt.factory.ExcelDAOFactory;

public class Client2 {

	public static void main(String[] args) {
		 DAO stDAO=null,courseDAO=null;
		 
		 stDAO=DBDAOFactory.getDAO("student");
		 stDAO.insert();
		 courseDAO=DBDAOFactory.getDAO("course");
		 courseDAO.insert();
	}//main
}//class
