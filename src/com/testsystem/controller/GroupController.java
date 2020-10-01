package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.Group;
import com.testsystem.model.Model;
import com.testsystem.model.Student;
import com.testsystem.model.StudentTestResult;
import com.testsystem.model.User;
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
	
	/**
	 * Creates a GroupController.
	 */
	public GroupController() {}
	
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
	 * 
	 * @param name the name of group
	 */
	public Group getNewGroup(String name) {
		return new Group(name);
	}
	
	/**
	 * Gets student by group.
	 * 
	 * @param group the group of user
	 */
	public List<User> getStudentsByGroup(Group group) {
		List<Student> listStudentInBase = ServiceLocator.getDaoProvider()
				.getStudentsRecords(new Student().getNameModel());
		List<User> listStudentReturn = new ArrayList<User>();
		for (int i = 0; i < listStudentInBase.size(); i++) {
			Student st = listStudentInBase.get(i);
			if (st.getGroup().equals(group)){
				listStudentReturn.add(st);
			}
		}
		return listStudentReturn;
	}
	
	/**
	 * Creates new group and adds it to database.
	 * 
	 * @param String the name of group to create and add
	 */
	public void addGroup(String name) {
		List<Model> groups = ServiceLocator.getDaoProvider()
				.getRecords(new Group().getNameModel());
		groups.add(new GroupController().getNewGroup(name));
	}

	/**
	 * Adds group.
	 * 
	 * @param group the group to add
	 */
	public void saveGroupIndatabase(Group group) {
		List<Model> groups = ServiceLocator.getDaoProvider()
				.getRecords(new Group().getNameModel());
		groups.add(group);
	}

	/**
	 * Gets group by name.
	 * 
	 * @param name the name of group
	 */
	public Group getGroupByName(String name) {
		List<Group> listGroup = ServiceLocator.getDaoProvider()
				.getGroupsRecords(new Group().getNameModel());
		for (int i = 0; i < listGroup.size(); i++) {
			Group g = listGroup.get(i);
			if (g.getName().equals(name)) {
				return g;
			}
		}
		return null;
	}
	
	/**
	 * Gets rating for group.
	 * 
	 * @param  nameGroup 				the name of group 		
	 * @return List<StudentTestResult>	the students results 
	 */
	public List<StudentTestResult> getRatingGroup(String nameGroup){
		Group group = this.getGroupByName(nameGroup);
		List<StudentTestResult> ratingGroup = RatingCalculator.getRatingGroup(group, new GroupController()
				.getStudentsByGroup(group));
		
		return ratingGroup;
	}
}
