# Task 2

### UserModel
Class `UserModel` is model the User. Varibles:
- `String name` - name user, there are getter and basic setter;
- `int level` - level user, there are getter, set value by setter `exp`;
- `int exp` - exp user, there are getter, setter:
if exp user with new exp >= 500 (there are exp for get new level), set in `exp` remainder and set in `level` the current value of a variable with an integer from division by 500.  if exp user with new exp less 500 exp - set in `exp` the current value of a variable with new exp.
```java
public void setExp(int exp) {
		if (this.exp + exp >= 500) {
			this.level += (int) ((this.exp + exp) / 500);
			this.exp = exp % 500;
		} else if (exp > 0)
			this.exp += exp;	
		else 
			this.exp = 0;
	}
```
- `boolean paid` - status user, there are getter and basic setter;
- `int countPossibleActions` - number of actions made by the user per day, there are getter and setter `increaseCounterAction`:
If status user is paid - increase counter action. If status user not paid check it out if `countPossibleActions` less 3 (limit action for user with not paid status) and increase counter action
```java
	public void increaseCounterAction() {
		if (paid)
			this.countPossibleActions++;
		else if (this.countPossibleActions < 3)
			this.countPossibleActions++;
	}
```
- `int countPaidDays` - number of days of paid status, there are getter.

**Methods:**
* `outputUser` - output information for user
```java
	public void outputUser() {
		System.out.print("#Username - " + name);
		if (paid)
			System.out.print("\t[Left " + countPaidDays + " days premium]");
		System.out.println("\n$Action taken: " + countPossibleActions);
		System.out.println("&Level: " + level + "\nExp: " + exp);
	}
```
* `nextDay` - ñalled at midnight and updates user data (reset action counter and decrement number of days paid status)
```java
	public void nextDay() {
		countPossibleActions = 0;
		if(paid) 
			countPaidDays--;
		if (countPaidDays == 0)
			paid = false;
	}
```

### UserView
Interface `UserView` to restrict access to a user's model from another thread.
```java
public interface UserView {
	void nextDay();
}
```

### Alarm
Class `Alarm` for method that will be run every day at midnight for every user. Constructor accepts interface `UserInterface` for job with `UserModel`  from other thread. Class `AlarmTask` launches another thread for method that will be run every day at midnight.
```java
public class Alarm {
    Timer _timer;
    UserView user;

    public Alarm(UserView user) {
    	this.user = user;
    	
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date alarmTime = calendar.getTime();

        _timer = new Timer();
        _timer.schedule(new AlarmTask(), alarmTime);
    }

    class AlarmTask extends TimerTask {
        public void run() {
        	user.nextDay();
        }
    }
}
```


### UserPresenter
Class `UserPresenter` is main class. Contains `List<UserModel> users` with users and object `UserController controller`. Main method `menu`:
```java
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
```

### UserController
Class `UserController` contains all the logic.
* method `input` is keyboard reader;
```java
private BufferedReader reader;
	public UserController() {reader = new BufferedReader(new InputStreamReader(System.in));}
	...
	public String input() {
		String s = "";
		try {
			s = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
```
* method `close` - close `BufferedReader`
```java
	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```
* method `createUser` for create new user
```java
public UserModel createUser() {
		UserModel user = new UserModel();
		user.setName(inputName());
		user.setPaid(inputPaid());
		return user;
	}
```
* method `inputName` for entering user name
```java
private String inputName() {
		System.out.print("Enter a username: ");
		String name = input();
		if (!name.equals("")) { //if name on empty
			for (char c: name.toCharArray())
			//could can only consist of characters "[a-z][A-Z][0-9]-._"
				if (!(c >= 'A' && c <= 'Z' 
				|| c >= 'a' && c <= 'z' 
				|| c >= '0' && c <= '9' 
				|| c == '-' || c == '.' || c == '_')) {	
					System.out.print("Username not valid. Use only consist of characters \"[a-z][A-Z][0-9]-._\".\n");
					return inputName();
				}

		} else {
			System.out.print("The name field can not be empty.\n");
			return inputName();
		}
		return name;
	}
```
* method `inputPaid` for choosing a user's status
```java
	private boolean inputPaid() {
		System.out.print("User is paid? [Y/N]: ");
		String answer = input();
		if (answer.equals("Y")) {
			return true;
		}
		return false;
	}
```
* method `representUser` of displaying information about the selected user
```java
	public void representUser(List<UserModel> users) {
		for (int i = 0; i < users.size(); i++)  //output list all users
			System.out.println((i + 1) + ". " + users.get(i).getName());
		System.out.print("Select user: ");
		int idUser = Integer.parseInt(input()) - 1; //select user
		
		users.get(idUser).outputUser(); //output information about user
	}
```
* method `emulatedAction` emulated random actions (number of actions and experience for them)
```java
public List<UserModel> emulatedAction(List<UserModel> users) {
		Random random = new Random();
		for (UserModel user: users) {
			int countAction = random.nextInt(5) + 1; //random number actions
			for (int i = 1; i <= countAction; i++) {
				if (user.isPaid() || countAction <= 3) { //if user status is paid or number actions less 3 - take action
					user.increaseCounterAction();
					user.setExp(random.nextInt(100) + 20);
				}
			}
		}
		return users;
	}
```