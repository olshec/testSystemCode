/**
 * 
 */
package controllers;

import java.util.List;

import models.UserBase;
import models.User;

/** AdministratorController
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class AdministratorController extends UserController {

	/**Creates an AdministratorController.
	 * @param userModel
	 */
	public AdministratorController(User userModel) {
		super(userModel);
	}
	
	/** Gets users by type.
	 * @param typeUser the user's type.
	 * @return List<UserModel> The list students.
	 */
	public List<User> getUsersByType(String typeUser, UserBase userBasemodel) {
		return new UserBaseController(userBasemodel).getUsersByType(typeUser);
	}
	
	/**
	 * @return List<UserModel> the list users.
	 */
	public List<User> getUsers(UserBase userBasemodel) {
		return new UserBaseController(userBasemodel).getUsers();
	}
	

}
