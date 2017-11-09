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
			accountInfo.getRecordInfo().add(date + " �����˻��ɹ�ȡ��" + money + "Ԫ");
		} else {
			accountInfo.getRecordInfo().add(date + " �����˻�δ��ȡ��" + money + "Ԫ");
		}
		return flat;
	}
}
