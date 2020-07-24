package com.testsystem.util;

import com.testsystem.DAO.DAOProvider;
import com.testsystem.controller.AdministratorController;
import com.testsystem.controller.StudentController;
import com.testsystem.controller.TeacherController;
import com.testsystem.controller.TestController;
import com.testsystem.controller.UserController;
import com.testsystem.models.Test;
import com.testsystem.models.User;

public class ServiceLocator {

	static DAOProvider daoProvider;
	
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
	 * @return the testController
	 */
	public static TestController getTestController(Test test) {
		return new TestController(daoProvider, test);
	}

	/**
	 * @return the userController
	 */
	public static UserController getUserController() {
		return new UserController(daoProvider);
	}
	
	/**
	 * @return the userController
	 */
	public static UserController getUserController(User user) {
		return new UserController(user, daoProvider);
	}
	
	/**
	 * @return the userController
	 */
	public static StudentController getStudentController() {
		return new StudentController(daoProvider);
	}
	
	/**
	 * @return the userController
	 */
	public static StudentController getStudentController(User user) {
		return new StudentController(user, daoProvider);
	}
	
	/**
	 * @return the userController
	 */
	public static AdministratorController getAdministratorController() {
		return new AdministratorController(daoProvider);
	}
	
	/**
	 * @return the userController
	 */
	public static AdministratorController getAdministratorController(User user) {
		return new AdministratorController(user, daoProvider);
	}
	
	/**
	 * @return the userController
	 */
	public static TeacherController getTeacherController() {
		return new TeacherController(daoProvider);
	}
	
	/**
	 * @return the userController
	 */
	public static TeacherController getTeacherController(User user) {
		return new TeacherController(user, daoProvider);
	}
}
