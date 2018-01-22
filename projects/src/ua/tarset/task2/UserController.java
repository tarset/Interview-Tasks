package ua.tarset.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UserController {
	private static Map<String, UserModel> users = new HashMap<>();

	public static void main(String args[]) {
		createUser();
	}
	
	private static void createUser() {
		UserModel user = new UserModel();
		
		try {
			user.setName(inputName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Okay. You username - " + user.getName());
		
	}
	
	private static String inputName() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a username: ");
		String name = reader.readLine();
		if (!name.equals("")) {
			for (char c: name.toCharArray())
				if (!(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c == '-' || c == '.' || c == '_')) {
					System.out.print("Username not valid. Use only consist of characters \"[a-z][A-Z][0-9]-._\".\n");
					return inputName();
				}

		}else {
		System.out.print("The name field can not be empty.\n");
		return inputName();
	}
		
		reader.close(); 
			return name;
	}
	
}
