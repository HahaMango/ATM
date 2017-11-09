package bank.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import bank.account.AccountInfo;
import bank.account.personInfo.PersonInfo;
import bank.account.recordInfo.RecordInfo;

public abstract class InitializeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		List<AccountInfo> list = new ArrayList<AccountInfo>();
		list.add(new AccountInfo(new PersonInfo("chen","zihua","669399333","228887",3221), new RecordInfo(new HashMap<Integer,String>())));
		list.add(new AccountInfo(new PersonInfo("peng", "runlian", "9807776666", "369369", 1000030), new RecordInfo(new HashMap<Integer,String>())));
		getServletContext().setAttribute("accountList", list);
	}

}
