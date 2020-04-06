package com.nt.test;

import com.nt.afp.DAOFactoryCreator;
import com.nt.dao.DAO;
import com.nt.factory.DAOFactory;
import com.nt.factory.DBDAOFactory;
import com.nt.factory.ExcelDAOFactory;

public class Client1 {

	public static void main(String[] args) {
		 DAO stDAO=null,courseDAO=null;
		 DAOFactory dbFactory=null;
		 //get DAOFactory using Supper Factory
		 dbFactory=DAOFactoryCreator.createDAOFactory("Db");
		 //get DAOs
		 stDAO=dbFactory.getDAO("student");
		 stDAO.insert();
		 courseDAO=dbFactory.getDAO("course");
		 courseDAO.insert();
		 
	}//main
}//class
