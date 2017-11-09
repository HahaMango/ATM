package bank.server;

import java.util.Date;

import bank.account.AccountInfo;

public class Transfer {
	private AccountInfo accountInfo_self;
	private AccountInfo accountInfo_to;
	private Date date = new Date();
	
	public Transfer(AccountInfo accountInfo_self,AccountInfo accountInfo_to) {
		// TODO Auto-generated constructor stub
		this.accountInfo_self=accountInfo_self;
		this.accountInfo_to=accountInfo_to;
	}
	
	public boolean transfer_money(float money) throws NullPointerException{
		boolean flat_self = accountInfo_self.getPersonInfo().decrease(money);
		boolean flat_to = accountInfo_to.getPersonInfo().increase(money);
		if(flat_self&&flat_to){
			accountInfo_self.getRecordInfo().add(date+" �����˺ųɹ�ת��"+money+"Ԫ");
			accountInfo_to.getRecordInfo().add(date+" �����˺ųɹ��յ�"+money+"Ԫ");
		}else {
			accountInfo_self.getRecordInfo().add(date+" �����˺�δ��ת��"+money+"Ԫ");
			accountInfo_to.getRecordInfo().add(date+" �����˺�δ���յ�"+money+"Ԫ");
		}
		return (flat_self&&flat_to);
	}
}
