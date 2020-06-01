package lab_2;

import java.util.ArrayList;
import java.util.List;

public class TestSystem {

	public static void main(String[] args) {

		
		Server server = new Server();
		//User user = server.login("REgor", "1111");
		//User user = server.login("KirovAnton", "12345678");
		User user = server.login( "Admin1", "0000");
		
		user.openMenu();
		
		
	}

}
