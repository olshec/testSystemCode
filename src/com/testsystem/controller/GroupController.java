package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.DAO.Providers.UserTableProvider;
import com.testsystem.DAO.Tables.UserTable;
import com.testsystem.models.Group;
import com.testsystem.models.Student;
import com.testsystem.models.User;

/**
 * Represents a GroupBaseController.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class GroupController {

	private Group group;
	
	/**
	 * Creates a GroupController.
	 */
	//public GroupController() {}
	
	/**
	 * Creates a GroupController.
	 * 
	 * @param group the group
	 */
	public GroupController(Group group) {
		setGroup(group);
	}
	
	/**
	 * Gets new Group.
	 */
	public static Group getNewGroup(String name) {
		return new Group(name);
	}
	
	/**
	 * Gets group.
	 * 
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * Sets group.
	 * 
	 * @param group the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * Gets student by group.
	 * 
	 * @param userBase the database of user
	 */
	public static List<User> getStudentByGroup(UserTable userBase, Group group) {
		List<User> listStudentInBase = new UserTableProvider(userBase)
				.getUsersByType(Student.nameModel);
		List<User> listStudent = new ArrayList<User>();
		for (int i = 0; i < listStudentInBase.size(); i++) {
			if (((Student)listStudentInBase.get(i)).getGroup().equals(group)){
				listStudent.add(listStudentInBase.get(i));
			}
		}
		return listStudent;
	}
}
