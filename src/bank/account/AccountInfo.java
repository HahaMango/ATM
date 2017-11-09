package bank.account;

import bank.account.personInfo.PersonInfo;
import bank.account.recordInfo.RecordInfo;

public class AccountInfo {
	private PersonInfo personInfo;
	private RecordInfo recordInfo;

	public AccountInfo(PersonInfo personInfo, RecordInfo recordInfo) {
		// TODO Auto-generated constructor stub
		this.personInfo = personInfo;
		this.recordInfo = recordInfo;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public RecordInfo getRecordInfo() {
		return recordInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public void setRecordInfo(RecordInfo recordInfo) {
		this.recordInfo = recordInfo;
	}
}
