package bank.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.account.AccountInfo;
import bank.server.Save;

@WebServlet(name = "SaveServlet", urlPatterns = { "/save" })
public class SaveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flat = false;
		String money_string = req.getParameter("money");
		float money = 0;
		if (money_string == null) {
			resp.sendRedirect("/Bank/errorPage/error.html");
			return;
		} else {
			money = Float.parseFloat(money_string);
		}

		HttpSession httpSession = req.getSession(false);
		if (httpSession != null) {
			AccountInfo accountInfo = (AccountInfo) httpSession.getAttribute("account");
			Save save = new Save(accountInfo);
			
			try {
				flat = save.saveMoney(money);
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
