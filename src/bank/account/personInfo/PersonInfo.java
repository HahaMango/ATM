package bank.account.personInfo;

import bank.account.interfaces.Account_able;

public class PersonInfo implements Account_able {
	private String firstName;
	private String lastName;
	private String id;
	private String password;
	private float money;

	public PersonInfo(String fn, String ln, String id, String pw, float money) {
		// TODO Auto-generated constructor stub
		setFirstName(fn);
		setLastName(ln);
		setId(id);
		setPassword(pw);
		setMoney(money);
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getId() {
		return this.id;
	}

	public String getPassword() {
		return this.password;
	}

	public float getMoney() {
		return this.money;
	}

	@Override
	public boolean increase(float i) {
		// TODO Auto-generated method stub
		float buf = getMoney() + i;
		if (buf > 0) {
			setMoney(buf);
			return true;
		} else
			return false;
	}

	@Override
	public boolean decrease(float i) {
		// TODO Auto-generated method stub
		float buf = getMoney() - i;
		if (buf > 0) {
			setMoney(buf);
			return true;
		} else
			return false;
	}
}
