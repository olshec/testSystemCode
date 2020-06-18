package lab_2;

import java.util.List;
import models.UserBaseModel;

public class UserBaseController {
	private UserBaseModel userBaseModel;

	public UserBaseController() {
		userBaseModel = new UserBaseModel();
	}

	public User getUser(String username, String password) {
		List<User> users=userBaseModel.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password)) {
				return users.get(i);
			}
		}
		return null;
	}

	public List<User> getUsers() {
		return userBaseModel.getUsers();
	}

	public void addUser(User user) {
		userBaseModel.getUsers().add(user);
	}

	public boolean hasUser(User user) {
		List<User> users=userBaseModel.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
				return true;
			}
		}
		return false;
	}

}
