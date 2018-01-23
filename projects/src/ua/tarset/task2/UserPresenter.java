package ua.tarset.task2;

import java.util.ArrayList;
import java.util.List;

public class UserPresenter {
	private static List<UserModel> users = new ArrayList<>();
	private static UserController controller = new UserController();
	public static void main(String args[]) {
		aa();
	}

	private static void aa() {
		
		System.out.println("1. Create User;"
				+ "\n2. Represent User.");
		switch(controller.input()) {
			case "1": 
				users.add(controller.createUser());
				aa();
				break;
			case "2": 
				controller.representUser(users.get(0));
				aa();
				break;
			case "3": 
				controller.close();
				break;
			default:
				break;
		}
	}

}
