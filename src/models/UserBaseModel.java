package models;

import java.util.ArrayList;
import java.util.List;

public class UserBaseModel {
	private List<UserModel> users;

	public UserBaseModel() {
		users = new ArrayList<UserModel>();
	}

	public List<UserModel> getUsers() {
		return users;
	}
	
	public void setUsers(List<UserModel> users) {
		this.users=users;
	}


}
