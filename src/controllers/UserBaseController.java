package controllers;

import java.util.ArrayList;
import java.util.List;

import models.UserModel;
import models.UserBaseModel;

/**
 * Represents a controller to the database containing user.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class UserBaseController {
	private UserBaseModel userBaseModel;

	/** Creates a UserBaseController.
	 */
	public UserBaseController() {
		userBaseModel = new UserBaseModel();
	}
	
	/** Creates a UserBaseController.
	 * @param userBaseModel the database containing user.
	 */
	public UserBaseController(UserBaseModel userBaseModel) {
		setUserBaseModel(userBaseModel);
	}

	/**
	 * @param username the name of user.
	 * @param password the password of user.
	 * @return UserModel the user.
	 */
	public UserModel getUser(String username, String password) {
		List<UserModel> users=userBaseModel.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password)) {
				return users.get(i);
			}
		}
		return null;
	}

	/**
	 * @return List<UserModel> the list users.
	 */
	public List<UserModel> getUsers() {
		return userBaseModel.getUsers();
	}

	/**
	 * @param user the user's model.
	 */
	public void addUser(UserModel user) {
		userBaseModel.getUsers().add(user);
	}

	/**
	 * @return boolean return true if database contains user.
	 */
	public boolean hasUser(UserModel user) {
		List<UserModel> users=userBaseModel.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the userBaseModel.
	 */
	public UserBaseModel getUserBaseModel() {
		return userBaseModel;
	}

	/**
	 * @param userBaseModel the userBaseModel to set.
	 */
	public void setUserBaseModel(UserBaseModel userBaseModel) {
		this.userBaseModel = userBaseModel;
	}

	/** Gets users by type.
	 * @param typeUser the user's type.
	 * @return List<UserModel> The list students.
	 */
	public List<UserModel> getUsersByType(String typeUser) {
		List<UserModel> masUserResult = new ArrayList<UserModel>();
		for (int i = 0; i <userBaseModel.getUsers().size(); i++) {
			String className = userBaseModel.getUsers().get(i).getClass().getSimpleName();
			if (className.equals(typeUser)) {
				masUserResult.add(userBaseModel.getUsers().get(i));
			}
		}
		return masUserResult;
	}
	

	
	
}
