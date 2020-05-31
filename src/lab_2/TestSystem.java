package lab_2;

import java.util.ArrayList;
import java.util.List;

public class TestSystem {

	public static void main(String[] args) {

		
		Server server = new Server();
		User user = server.login("REgor", "1111");
		
		
		
		user.openMenu();
		
		
	}

}
