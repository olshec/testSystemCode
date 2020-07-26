package com.testsystem.models;

import com.testsystem.DAO.DAOProvider2;

public abstract class Model {

	public Model() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	public abstract String getNameModel();

	public void getN(){
		DAOProvider2 dao2=new DAOProvider2();
		Group st;
		st = (Group) dao2.getRecordsTable(Group.nameModel).get(0);
		st.getName();
	}
}
