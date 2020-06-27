package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a database user.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class UserBaseModel {
	private List<UserModel> users;

	/**Creates a UserBaseModel.
	 */
	public UserBaseModel() {
		users = new ArrayList<UserModel>();
	}
	
	/**Creates a UserBaseModel.
	 * @param users
	 */
	public UserBaseModel(List<UserModel> users) {
		super();
		this.users = users;
	}


	/**
	 * @return the list users
	 */
	public List<UserModel> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<UserModel> users) {
		this.users = users;
	}




}
