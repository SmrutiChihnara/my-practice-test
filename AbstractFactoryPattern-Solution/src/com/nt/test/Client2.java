package com.nt.test;

import com.nt.afp.DAOFactoryCreator;
import com.nt.commons.FactoryTypes;
import com.nt.dao.DAO;
import com.nt.factory.DAOFactory;
import com.nt.factory.DBDAOFactory;
import com.nt.factory.ExcelDAOFactory;

public class Client2 {

	public static void main(String[] args) {
		DAO stDAO=null,courseDAO=null;
		 DAOFactory dbFactory=null;
		 //get DAOFactory using Supper Factory
		 dbFactory=DAOFactoryCreator.createDAOFactory(FactoryTypes.FACTORY_STORE_EXCEL);
		 //get DAOs
		 stDAO=dbFactory.getDAO(FactoryTypes.DAO_TYPE_STUDENT);
		 stDAO.insert();
		 courseDAO=dbFactory.getDAO(FactoryTypes.DAO_TYPE_COURSE);
		 courseDAO.insert();
	}//main
}//class
