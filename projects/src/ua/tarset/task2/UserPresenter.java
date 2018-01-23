package ua.tarset.task2;

import java.util.ArrayList;
import java.util.List;

public class UserPresenter {
	private static List<UserModel> users = new ArrayList<>();
	private static UserController controller = new UserController();
	public static void main(String args[]) {
		menu();
	}

	private static void menu() {
		
		System.out.println("1. Create User;"
				+ "\n2. Represent User;"
				+ "\n3. Emulated day;"
				+ "\n4. Exit.");
		System.out.print("Select item menu: ");
		switch(controller.input()) {
			case "1": 
				users.add(controller.createUser());
				menu();
				break;
			case "2": 
				controller.representUser(users);
				menu();
				break;
			case "3": 
				controller.emulatedDay(users);
				menu();
				break;
			case "4": 
				controller.close();
				break;
			default:
				break;
		}
	}

}
