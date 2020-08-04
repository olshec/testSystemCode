package com.testsystem.util;

import com.testsystem.DAO.DAOProvider;
import com.testsystem.controller.AdministratorController;
import com.testsystem.controller.GroupController;
import com.testsystem.controller.StudentController;
import com.testsystem.controller.TeacherController;
import com.testsystem.controller.TestController;
import com.testsystem.controller.UserController;
import com.testsystem.models.Group;
import com.testsystem.models.Test;
import com.testsystem.models.User;

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
	
	/**
	 * @return the testController
	 */
	public static GroupController getGroupController(Group group) {
		return new GroupController(group);
	}
	
	/**
	 * @return the testController
	 */
	public static TestController getTestController(Test test) {
		return new TestController(test);
	}

	/**
	 * @return the userController
	 */
	public static UserController getUserController() {
		return new UserController();
	}
	
	/**
	 * @return the userController
	 */
	public static UserController getUserController(User user) {
		return new UserController(user);
	}
	
	/**
	 * @return the userController
	 */
	public static StudentController getStudentController(User user) {
		return new StudentController(user);
	}
	
	/**
	 * @return the userController
	 */
	public static AdministratorController getAdministratorController(User user) {
		return new AdministratorController(user);
	}
	
	/**
	 * @return the userController
	 */
	public static TeacherController getTeacherController(User user) {
		return new TeacherController(user);
	}
}
