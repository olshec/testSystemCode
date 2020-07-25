package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.DAO.DAOProvider;
import com.testsystem.DAO.Tables.Table;
import com.testsystem.models.Group;
import com.testsystem.models.Student;
import com.testsystem.models.User;
import com.testsystem.util.ServiceLocator;

/**
 * Represents a GroupBaseController.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class GroupController {

	private Group group;
	private DAOProvider daoProvider;

	/**
	 * Creates a GroupController.
	 * 
	 * @param group the group
	 */
	public GroupController(Group group) {
		setGroup(group);
	}
	
	/**
	 * Creates a GroupController.
	 * 
	 * @param group the group
	 */
	public GroupController(DAOProvider daoProvider) {
		setDaoProvider(daoProvider);
	}
	
	/**
	 * Creates a GroupController.
	 * 
	 * @param group the group
	 */
	public GroupController(Group group, DAOProvider daoProvider) {
		setGroup(group);
		setDaoProvider(daoProvider);
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
	 * Sets DAOProvider.
	 * 
	 * @param daoProvider the DAOProvider to set
	 */
	public void setDaoProvider(DAOProvider daoProvider) {
		this.daoProvider = daoProvider;
	}
	
	/**
	 * Gets new Group.
	 */
	public static Group getNewGroup(String name) {
		return new Group(name);
	}
	
	/**
	 * Gets student by group.
	 * 
	 * @param group the group of user
	 */
	public List<User> getStudentsByGroup(Group group) {
		List<User> listStudentInBase = ServiceLocator.getUserController()
				.getUsersByType(Student.nameModel);
		List<User> listStudent = new ArrayList<User>();
		for (int i = 0; i < listStudentInBase.size(); i++) {
			if (((Student)listStudentInBase.get(i)).getGroup().equals(group)){
				listStudent.add(listStudentInBase.get(i));
			}
		}
		return listStudent;
	}
	
	/**
	 * Creates new group and adds it to database.
	 * 
	 * @param String the name of group to create and add
	 */
	public void addGroup(String name) {
		List<Group> groups = ((Table<Group>)daoProvider
				.getTable(Group.nameModel)).getListRecord();
		groups.add(GroupController.getNewGroup(name));
	}

	/**
	 * Adds group.
	 * 
	 * @param group the group to add
	 */
	public void addGroup(Group group) {
		List<Group> groups = ((Table<Group>)daoProvider
				.getTable(Group.nameModel)).getListRecord();
		groups.add(group);
	}

	/**
	 * Gets group by name.
	 * 
	 * @param name the name of group
	 */
	public Group getGroupByName(String name) {
		List<Group> listGroup = ((Table<Group>)daoProvider.getTable(Group.nameModel)).getListRecord();
		for (int i = 0; i < listGroup.size(); i++) {
			if (listGroup.get(i).getName().equals(name)) {
				return listGroup.get(i);
			}
		}
		return null;
	}
}
