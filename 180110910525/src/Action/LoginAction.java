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
 * ��¼��servlet����
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ��ȡ�û�������û���
		String username = request.getParameter("username");
		// ��ȡ����
		String password = request.getParameter("password");

		String jym = request.getParameter("jym");

		// �ȱȽ�У����
		// ��ȡsession�е�У����
		HttpSession session = request.getSession();
		String s_verf = (String) session.getAttribute("verf");

		// �Ƚ������У������session�е��Ƿ�һ��
		if (s_verf != null && s_verf.equals(jym)) {
			// ���һ��
			TUser u = UserService.login(username, password);
			if (u != null) {

				// ��ȡ�Ự����

				session.setAttribute("user", u);

				// �Ƴ�
				session.removeAttribute("verf");

				// ��ȷ��ת�����ɹ�ҳ��
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("info", "�û�������������������룡");

				request.setAttribute("input_name", username);

				// ת��
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
			}
		}
		// ���һ��У���û���������

		//
		else {
			// ����У���벻��
			request.setAttribute("info", "У�������");

			request.setAttribute("input_name", username);

			// ת��
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
