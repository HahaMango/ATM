package bank.server;

import java.util.Date;

import bank.account.AccountInfo;

public class Save {
	private AccountInfo accountInfo;
	private Date date = new Date();

	public Save(AccountInfo accountInfo) {
		// TODO Auto-generated constructor stub
		this.accountInfo = accountInfo;
	}

	public boolean saveMoney(float money) throws NullPointerException {
		boolean flat = accountInfo.getPersonInfo().increase(money);
		if (flat) {
			accountInfo.getRecordInfo().add(date + " 您的账户成功存入" + money + "元");
		} else {
			accountInfo.getRecordInfo().add(date + " 您的账户未能存入" + money + "元");
		}
		return flat;
	}
}
