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
 * 注册处理Servlet
 */
@WebServlet("/RegAction")
public class RegAciton extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 请求
		request.setCharacterEncoding("utf-8");

		// 获取用户名
		String username = request.getParameter("username");

		// 获取密码
		String pass = request.getParameter("password");

		// 获取昵称
		String nickname = request.getParameter("nickname");
		
		// 获取ID
		String ID = request.getParameter("ID");

		

		// 写入数据库

		try {
			// 注册驱动
			Class.forName("com.mysql.jdbc.Driver");

			String url = "JDBC:mysql://localhost:3306/db_180110910525?useUnicode=true&characterEncoding=UTF-8";

			String user = "root";

			String password = "123456";

			Connection conn = DriverManager.getConnection(url, user, password);

			// 获取用于向数据库发送sql语句的statement

			String sql = "insert into db_180110910525.t_user(u_username,u_password,u_nickname,u_id,u_type) VALUES(?,?,?,?,0)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			ps.setString(3, nickname);
			ps.setString(4, ID);
			

			// 向数据库发送sql语句，并获取结果
			ps.executeUpdate();

			ps.close();

			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动没有找到!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库链接发生异常!");
			e.printStackTrace();
		}

		// 转发
		request.getRequestDispatcher("Login").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
