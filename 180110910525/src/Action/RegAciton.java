package Action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ע�ᴦ��Servlet
 */
@WebServlet("/RegAction")
public class RegAciton extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����
		request.setCharacterEncoding("utf-8");

		// ��ȡ�û���
		String username = request.getParameter("username");

		// ��ȡ����
		String pass = request.getParameter("password");

		// ��ȡ�ǳ�
		String nickname = request.getParameter("nickname");
		
		// ��ȡID
		String ID = request.getParameter("ID");

		

		// д�����ݿ�

		try {
			// ע������
			Class.forName("com.mysql.jdbc.Driver");

			String url = "JDBC:mysql://localhost:3306/db_180110910525?useUnicode=true&characterEncoding=UTF-8";

			String user = "root";

			String password = "123456";

			Connection conn = DriverManager.getConnection(url, user, password);

			// ��ȡ���������ݿⷢ��sql����statement

			String sql = "insert into db_180110910525.t_user(u_username,u_password,u_nickname,u_id,u_type) VALUES(?,?,?,?,0)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			ps.setString(3, nickname);
			ps.setString(4, ID);
			

			// �����ݿⷢ��sql��䣬����ȡ���
			ps.executeUpdate();

			ps.close();

			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ�����û���ҵ�!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���ݿ����ӷ����쳣!");
			e.printStackTrace();
		}

		// ת��
		request.getRequestDispatcher("Login").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
