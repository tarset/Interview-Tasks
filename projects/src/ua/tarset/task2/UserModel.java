package ua.tarset.task2;

public class UserModel {
	private String name = "";
	private int level = 0;
	private int exp = 0;
	private boolean paid = false;
	private int countPossibleActions = 0;
	private int countPaidDays = 0;
	
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
	public void setCountPossibleActions(int countPossibleActions) {
		if (paid)
			this.countPossibleActions = countPossibleActions;
		else if (countPossibleActions <= 3)
			this.countPossibleActions = countPossibleActions;
		else if (countPossibleActions > 3)
			this.countPossibleActions = 3;
	}
	
	public int getCountPaidDays() {
		return countPaidDays;
	}
	
}
