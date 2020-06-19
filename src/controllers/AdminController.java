package controllers;

import java.util.List;

import models.AdminModel;
import models.UserModel;

public class AdminController {
	private AdminModel userModel;
	
	
	
	public AdminController(AdminModel userModel) {
		this.userModel=userModel;
	}
	
	
	public List<UserModel> getUsers() {
		List<UserModel> masUser = this.userModel.getServer().getAllUsersForAdmin();
		return masUser;
	}
	

}
