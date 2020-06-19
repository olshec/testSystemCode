package views;


import models.UserModel;

public abstract class UserView {
	private UserModel userModel;
	
	public abstract void openMenu();
	
	public UserView(UserModel userModel) {
		setUserModel(userModel);
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	
}
