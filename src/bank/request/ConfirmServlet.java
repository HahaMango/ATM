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

@WebServlet(name = "ConfirmServlet", urlPatterns = { "/confirm" })
public class ConfirmServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		boolean flat = false;
		HttpSession httpSession = req.getSession();

		if (httpSession.getAttribute("account") == null) {
			if (id != null && password != null) {
				List<AccountInfo> list = (List<AccountInfo>) getServletContext().getAttribute("accountList");
				for (AccountInfo accountInfo : list) {
					if (accountInfo.getPersonInfo().getId().equals(id)
							&& accountInfo.getPersonInfo().getPassword().equals(password)) {
						httpSession.setAttribute("account", accountInfo);
						flat = true;
					}
				}
				if (flat) {
					req.getRequestDispatcher("/confirmPage/sccess.jsp").forward(req, resp);
				} else
					req.getRequestDispatcher("/confirmPage/notfound.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/confirmPage/turnback.jsp").forward(req, resp);
			}
		} else {
			req.getRequestDispatcher("/confirmPage/sccess.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getSession(false) != null) {
			req.getRequestDispatcher("/confirmPage/sccess.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/Bank/welcome.jsp");
		}
	}
}
