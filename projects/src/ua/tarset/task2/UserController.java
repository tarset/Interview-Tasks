package ua.tarset.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public List<UserModel> emulatedAction(List<UserModel> users) {
		Random random = new Random();
		for (UserModel user: users) {
			int countAction = random.nextInt(5) + 1;
			for (int i = 1; i <= countAction; i++) {
				if (user.isPaid() || countAction <= 3) {
					user.setCountPossibleActions(1);
					user.setExp(random.nextInt(100) + 20);
				}
			}
		}
		return users;
	}

	public void representUser(List<UserModel> users) {
		for (int i = 0; i < users.size(); i++) 
			System.out.println((i + 1) + ". " + users.get(i).getName());
		System.out.print("Select user: ");
		int idUser = Integer.parseInt(input()) - 1;
		
		users.get(idUser).outputUser();
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
		System.out.print("Enter a username: ");
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
