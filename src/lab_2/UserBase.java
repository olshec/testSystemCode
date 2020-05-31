package lab_2;

import java.util.ArrayList;
import java.util.List;

public class UserBase {
	List<User> users;

	public UserBase() {
		users=new ArrayList<User>();
	}
	
	public  User getUser(String username, String password) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName() == username &&
					users.get(i).getPassword() == password) {
				return users.get(i);
			}
		}
		return null;
	}

	public List<User> getUsers() {
		return users;
	}
	
	public void addUser(User user) {
		users.add(user);
	}

	public boolean hasUser(User user) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
