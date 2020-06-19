package controllers;

import java.util.List;

import models.UserModel;
import models.UserBaseModel;

public class UserBaseController {
	private UserBaseModel userBaseModel;

	public UserBaseController() {
		userBaseModel = new UserBaseModel();
	}

	public UserModel getUser(String username, String password) {
		List<UserModel> users=userBaseModel.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password)) {
				return users.get(i);
			}
		}
		return null;
	}

	public List<UserModel> getUsers() {
		return userBaseModel.getUsers();
	}

	public void addUser(UserModel user) {
		userBaseModel.getUsers().add(user);
	}

	public boolean hasUser(UserModel user) {
		List<UserModel> users=userBaseModel.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
				return true;
			}
		}
		return false;
	}

}
