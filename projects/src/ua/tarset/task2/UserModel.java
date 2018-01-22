package ua.tarset.task2;

public class UserModel {
	private String name = "";
	private int level = 0;
	private int exp = 0;
	private boolean paid = false;
	private int countPossibleActions = 3;
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
		if (exp > 0)
			this.exp = exp;	
		else 
			this.exp = 0;
		
		if (this.exp / 500 >= 1)
			this.level += (int) (this.exp / 500);
	}
	
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public int getCountPossibleActions() {
		return countPossibleActions;
	}
	public void setCountPossibleActions(int countPossibleActions) {
		this.countPossibleActions = countPossibleActions;
	}
	
	public int getCountPaidDays() {
		return countPaidDays;
	}
	public void setCountPaidDays(int countPaidDays) {
		this.countPaidDays = countPaidDays;
	} 
	
}
