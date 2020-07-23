package com.testsystem.DAO;

import com.testsystem.DAO.Tables.GroupTable;
import com.testsystem.DAO.Tables.TestTable;
import com.testsystem.DAO.Tables.UserTable;

/**
 * Represents a DAOProvider.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class DAOProvider {

	private TestTable testTable;
	private UserTable userTable;
	private GroupTable groupTable;
	
	/**
	 * Creates a DAOProvider.
	 */
	public DAOProvider() {
		setTestTable(new TestTable());
		setUserTable(new UserTable());
		setGroupTable(new GroupTable());
	}

	/**
	 * Gets table of test.
	 * 
	 * @return the testTable
	 */
	public TestTable getTestTable() {
		return testTable;
	}

	/**
	 * Sets table of test.
	 *  
	 * @param testTable the testTable to set
	 */
	public void setTestTable(TestTable testTable) {
		this.testTable = testTable;
	}

	/**
	 * Gets table of user.
	 *  
	 * @return the userTable
	 */
	public UserTable getUserTable() {
		return userTable;
	}

	/**
	 * Sets table of user.
	 * 
	 * @param userTable the userTable to set
	 */
	public void setUserTable(UserTable userTable) {
		this.userTable = userTable;
	}

	/**
	 * Gets table of group.
	 * 
	 * @return the groupTable
	 */
	public GroupTable getGroupTable() {
		return groupTable;
	}

	/**
	 * Sets table of group.
	 * 
	 * @param groupTable the groupTable to set
	 */
	public void setGroupTable(GroupTable groupTable) {
		this.groupTable = groupTable;
	}
	
	/**
	 * Clears DAOProvider tables.
	 */
	public void clear() {
		testTable.getTests().clear();
		userTable.getUsers().clear();
		groupTable.getGroups().clear();
	}
}
