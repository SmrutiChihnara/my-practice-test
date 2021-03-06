package com.nt.factory;

import com.nt.dao.DAO;
import com.nt.dao.DBCourseDAOImpl;
import com.nt.dao.DBStudentDAOImpl;
import com.nt.dao.ExcelCourseDAOImpl;
import com.nt.dao.ExcelStudentDAOImpl;

public class ExcelDAOFactory implements DAOFactory{
	
	public  DAO getDAO(String type){
		DAO dao=null;
		if(type.equalsIgnoreCase("student")){
			dao=new ExcelStudentDAOImpl();
		}
		else if(type.equalsIgnoreCase("course")){
			dao=new ExcelCourseDAOImpl();
		}
		else{
		  throw new IllegalArgumentException("invalid type");	
		}
		return dao; 
	}

}
