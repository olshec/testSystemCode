package controllers;
import models.UserModel;

/**
 * 
 */

/**
 * @author user1
 *
 */
public abstract class UserController {

	UserModel userModel;
	
	/**
	 * Creates a UserController.
	 */
	public UserController(UserModel userModel) {
		this.userModel=userModel;
	}
	
	/**
	 * @return the userModel
	 */
	public UserModel getUserModel() {
		return userModel;
	}
	
	/**
	 * @param userModel the userModel to set
	 */
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	

}
