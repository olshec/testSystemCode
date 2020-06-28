package views;


import models.UserModel;

public abstract class UserView {
	private UserModel userModel;
	
	/** Menu.
	*/
	public abstract void openMenu();
	
	/** Creates a UserView.
	 */
	public UserView() {}
	
	/** Creates a UserView.
	 */
	public UserView(UserModel userModel) {
		setUserModel(userModel);
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
