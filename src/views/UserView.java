package views;


import models.User;

public abstract class UserView {
	private User userModel;
	
	/** Menu.
	*/
	public abstract void openMenu();
	
	/** Creates a UserView.
	 */
	public UserView() {}
	
	/** Creates a UserView.
	 */
	public UserView(User userModel) {
		setUserModel(userModel);
	}

	/**
	 * @return the userModel
	 */
	public User getUserModel() {
		return userModel;
	}

	/**
	 * @param userModel the userModel to set
	 */
	public void setUserModel(User userModel) { 
		this.userModel = userModel;
	}


	
	
}
