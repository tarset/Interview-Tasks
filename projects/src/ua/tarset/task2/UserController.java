package ua.tarset.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UserController {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String input() {
		String s = "";
		try {
			s = reader.readLine();
			//reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	public void representUser(UserModel user) {
		System.out.println("Username - " + user.getName());
		if (user.isPaid())
			System.out.println("This is user a paid. Days left: " + user.getCountPaidDays());
		else
			System.out.println("This is user a free. Left action: " + user.getCountPossibleActions());
		System.out.println("Level: " + user.getLevel() + "\nExp: " + user.getExp());
	}

	public UserModel createUser() {
		UserModel user = new UserModel();

		user.setName(inputName());
		user.setPaid(inputPaid());

		return user;
	}

	private boolean inputPaid() {
		System.out.print("User is paid? [Y/N]: ");
		String answer = input();
		if (answer.equals("Y")) {
			return true;
		}
		return false;
	}

	private String inputName() {
		System.out.println("Enter a username: ");
		String name = input();
		if (!name.equals("")) {
			for (char c: name.toCharArray())
				if (!(c >= 'A' && c <= 'Z' 
				|| c >= 'a' && c <= 'z' 
				|| c >= '0' && c <= '9' 
				|| c == '-' || c == '.' || c == '_')) {	
					System.out.print("Username not valid. Use only consist of characters \"[a-z][A-Z][0-9]-._\".\n");
					return inputName();
				}

		}else {
			System.out.print("The name field can not be empty.\n");
			return inputName();
		}
		return name;
	}

}
