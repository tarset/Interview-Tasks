package ua.tarset.task2;

public class UserModel implements UserView {
	private String name = "";
	private int level = 0;
	private int exp = 0;
	private boolean paid = false;
	private int countPossibleActions = 0;
	private int countPaidDays = 0;
	
	public UserModel() {
		new Alarm(this);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		if (this.exp + exp >= 500) {
			this.level += (int) ((this.exp + exp) / 500);
			this.exp = exp % 500;
		} else if (exp > 0)
			this.exp += exp;	
		else 
			this.exp = 0;
	}
	
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.countPaidDays = 5;
		this.paid = paid;
	}
	
	public int getCountPossibleActions() {
		return countPossibleActions;
	}
	public void increaseCounterAction() {
		if (paid)
			this.countPossibleActions++;
		else if (this.countPossibleActions < 3)
			this.countPossibleActions++;
	}
	
	public int getCountPaidDays() {
		return countPaidDays;
	}
	
	public void outputUser() {
		System.out.print("#Username - " + name);
		if (paid)
			System.out.print("\t[Left " + countPaidDays + " days premium]");
		System.out.println("\n$Action taken: " + countPossibleActions);
		System.out.println("&Level: " + level + "\nExp: " + exp);
	}
	
	public void nextDay() {
		countPossibleActions = 0;
		if(paid) 
			countPaidDays--;
		if (countPaidDays == 0)
			paid = false;
	}
	
}