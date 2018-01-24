package ua.tarset.task2;

import java.util.ArrayList;
import java.util.List;

public class UserPresenter {
	private static List<UserModel> users;
	private static UserController controller;

	public static void main(String args[]) {
		users = new ArrayList<>();
		controller = new UserController();

		menu();
	}

	private static void menu() {
		System.out.println("1. Create user;"
				+ "\n2. Represent user;"
				+ "\n3. Emulated action;"
				+ "\n4. Exit.");

		System.out.print("Select item menu: ");
		String selectItem = controller.input();
		if (selectItem.equals("4")) {
			controller.close();
			return;
		}
		if (selectItem.equals("1")) users.add(controller.createUser());
		if (selectItem.equals("2")) controller.representUser(users);
		if (selectItem.equals("3")) controller.emulatedAction(users);

		menu();
	}

}
