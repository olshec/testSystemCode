package com.testsystem.util;

import com.testsystem.DAO.DAOProvider;
import com.testsystem.controller.TestController;
import com.testsystem.controller.UserController;

public class ServiceLocator {

	static DAOProvider daoProvider;
	static TestController testController;
	static UserController userController;
	
	public ServiceLocator() {}

	/**
	 * @return the daoProvider
	 */
	public DAOProvider getDaoProvider() {
		return daoProvider;
	}

	/**
	 * @param daoProvider the daoProvider to set
	 */
	public static void setDaoProvider(DAOProvider daoProvider) {
		ServiceLocator.daoProvider = daoProvider;
	}

	/**
	 * @return the testController
	 */
	public static TestController getTestController() {
		return new TestController(daoProvider);
	}

	/**
	 * @return the userController
	 */
	public static UserController getUserController() {
		return new UserController(daoProvider);
	}
}
