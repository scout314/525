package Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UserService;
import flight.entity.TUser;



/**
 * 登录的servlet操作
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取用户输入的用户名
		String username = request.getParameter("username");
		// 获取密码
		String password = request.getParameter("password");

		String jym = request.getParameter("jym");

		// 先比较校验码
		// 获取session中的校验码
		HttpSession session = request.getSession();
		String s_verf = (String) session.getAttribute("verf");

		// 比较输入的校验码与session中的是否一致
		if (s_verf != null && s_verf.equals(jym)) {
			// 如果一致
			TUser u = UserService.login(username, password);
			if (u != null) {

				// 获取会话对象

				session.setAttribute("user", u);

				// 移除
				session.removeAttribute("verf");

				// 正确，转发到成功页面
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("info", "用户名密码错误，请重新输入！");

				request.setAttribute("input_name", username);

				// 转发
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
			}
		}
		// 如果一致校验用户名和密码

		//
		else {
			// 输入校验码不对
			request.setAttribute("info", "校验码错误！");

			request.setAttribute("input_name", username);

			// 转发
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
