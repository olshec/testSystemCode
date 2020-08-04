package com.testsystem.util;

import com.testsystem.DAO.DAOProvider;

/**
 * Represents a ServiceLocator.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class ServiceLocator {

	static DAOProvider daoProvider;
	
	private ServiceLocator() {}

	/**
	 * @return the daoProvider
	 */
	public static DAOProvider getDaoProvider() {
		return daoProvider;
	}

	/**
	 * @param daoProvider the daoProvider to set
	 */
	public static void setDaoProvider(DAOProvider daoProvider) {
		ServiceLocator.daoProvider = daoProvider;
	}
}
