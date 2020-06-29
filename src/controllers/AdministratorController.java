/**
 * 
 */
package controllers;

import java.util.List;

import models.UserBaseModel;
import models.UserModel;

/** AdministratorController
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class AdministratorController extends UserController {

	/**Creates an AdministratorController.
	 * @param userModel
	 */
	public AdministratorController(UserModel userModel) {
		super(userModel);
	}
	
	/** Gets users by type.
	 * @param typeUser the user's type.
	 * @return List<UserModel> The list students.
	 */
	public List<UserModel> getUsersByType(String typeUser, UserBaseModel userBasemodel) {
		return new UserBaseController(userBasemodel).getUsersByType(typeUser);
	}
	
	/**
	 * @return List<UserModel> the list users.
	 */
	public List<UserModel> getUsers(UserBaseModel userBasemodel) {
		return new UserBaseController(userBasemodel).getUsers();
	}
	

}
