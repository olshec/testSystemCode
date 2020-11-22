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
	
	/**
	 * Creates a ServiceLocator.
	 */
	private ServiceLocator() {}

	/**
	 * Returns the DAOProvider
	 * 
	 * @return DAOProvider the DAOProvider
	 */
	public static DAOProvider getDaoProvider() {
		return daoProvider;
	}

	/**
	 * Sets the DAOProvider.
	 * 
	 * @param DAOProvider the DAOProvider
	 */
	public static void setDaoProvider(DAOProvider daoProvider) {
		ServiceLocator.daoProvider = daoProvider;
	}
}
