package bank.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.account.AccountInfo;
import bank.server.Transfer;

@WebServlet(name = "TransferServelt", urlPatterns = { "/transfer" })
public class TransferServelt extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flat = false;
		String id_to = req.getParameter("id");
		String money_string = req.getParameter("money");
		float money = 0;
		if (id_to == null || money_string == null) {
			resp.sendRedirect("/Bank/errorPage/error.html");
			return;
		} else {
			money = Float.parseFloat(money_string);
		}

		HttpSession httpSession = req.getSession(false);
		if (httpSession != null) {
			AccountInfo accountInfo_self;
			AccountInfo accountInfo_to = null;
			accountInfo_self = (AccountInfo) httpSession.getAttribute("account");
			@SuppressWarnings("unchecked")
			List<AccountInfo> list = (List<AccountInfo>) getServletContext().getAttribute("accountList");
			for (AccountInfo accountInfo : list) {
				if (accountInfo.getPersonInfo().getId().equals(id_to)) {
					accountInfo_to = accountInfo;
					break;
				}
			}

			Transfer transfer = new Transfer(accountInfo_self, accountInfo_to);
			try {
				flat = transfer.transfer_money(money);
			} catch (NullPointerException e) {
				// TODO: handle exception
				resp.sendRedirect("/Bank/errorPage/error.html");
				return;
			}
		}
		if (flat) {
			resp.sendRedirect("/Bank/sccessPage/OK.html");
		} else {
			resp.sendRedirect("/Bank/errorPage/error.html");
		}
	}

}
