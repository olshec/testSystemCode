package controllers;
import models.UserModel;

/**
 * 
 */

/**
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public abstract class UserController {

	UserModel userModel;
	
	/**
	 * Creates an UserController.
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
