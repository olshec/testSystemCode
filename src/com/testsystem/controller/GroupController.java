package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.Group;
import com.testsystem.models.Model;
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

	
	public GroupController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Creates a GroupController.
	 * 
	 * @param group the group
	 */
	public GroupController(Group group) {
		setGroup(group);
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
		List<Model> listStudentInBase = ServiceLocator.getDaoProvider()
				.getRecordsTable(Student.nameModel);
		List<User> listStudent = new ArrayList<User>();
		for (int i = 0; i < listStudentInBase.size(); i++) {
			Student st = (Student)listStudentInBase.get(i);
			if (st.getGroup().equals(group)){
				listStudent.add(st);
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
		List<Model> groups = ServiceLocator.getDaoProvider()
				.getRecordsTable(Group.nameModel);
		groups.add(GroupController.getNewGroup(name));
	}

	/**
	 * Adds group.
	 * 
	 * @param group the group to add
	 */
	public void addGroup(Group group) {
		List<Model> groups = ServiceLocator.getDaoProvider()
				.getRecordsTable(Group.nameModel);
		groups.add(group);
	}

	/**
	 * Gets group by name.
	 * 
	 * @param name the name of group
	 */
	public Group getGroupByName(String name) {
		List<Model> listGroup = ServiceLocator.getDaoProvider()
				.getRecordsTable(Group.nameModel);
		for (int i = 0; i < listGroup.size(); i++) {
			Group g = (Group)listGroup.get(i);
			if (g.getName().equals(name)) {
				return g;
			}
		}
		return null;
	}
}
