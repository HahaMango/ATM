package bank.server;

import java.util.Date;

import bank.account.AccountInfo;

public class Withdraw {
	private AccountInfo accountInfo;
	private Date date = new Date();

	public Withdraw(AccountInfo accountInfo) {
		// TODO Auto-generated constructor stub
		this.accountInfo = accountInfo;
	}

	public boolean withdrawMoney(float money) throws NullPointerException{
		boolean flat = accountInfo.getPersonInfo().decrease(money);
		if (flat) {
			accountInfo.getRecordInfo().add(date + " 您的账户成功取出" + money + "元");
		} else {
			accountInfo.getRecordInfo().add(date + " 您的账户未能取出" + money + "元");
		}
		return flat;
	}
}
