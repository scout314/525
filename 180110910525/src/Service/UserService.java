package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import flight.entity.TFlight;
import flight.entity.TOrder;
import flight.entity.TUser;

public class UserService {
	public static Connection getConnect() {

		// 1 注册驱动

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 2 建立连接

			String url = "JDBC:mysql://localhost:3306/db_180110910525?useUnicode=true&characterEncoding=UTF-8";

			Connection conn = DriverManager.getConnection(url, "root", "123456");

			return conn;

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			System.out.println("数据库连接错误！！");

			e.printStackTrace();
		}

		return null;

	}

	

	/// 用户登录
	public static TUser login(String username, String password) {
		Connection conn = UserService.getConnect();

		QueryRunner runner = new QueryRunner();

		String sql1 = "select * from t_user where u_username=? and u_password=?";

		List<TUser> users;
		try {
			users = runner.query(conn, sql1, new BeanListHandler<TUser>(TUser.class), username, password);

			DbUtils.closeQuietly(conn);

			if (users.size() > 0)
				return users.get(0);
			else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取所有的航班数据
	public static List<TFlight> getFlight(int pageSize,int pageNo) {

		// 获取数据库连接
		Connection conn = UserService.getConnect();

		// QueryRunner Dbutils核心类
		QueryRunner runner = new QueryRunner();

		// String sql1 = "select * from t_flight as f join t_airplane as a on
		// f.f_a_no=a.a_no";
		String sql1 = "select * from t_flight limit ?,?";

		List<TFlight> flight = new ArrayList<>();

		try {
			// 查询所有的用户数据，结果放入 List<TFlight>
			flight = runner.query(conn, sql1, new BeanListHandler<TFlight>(TFlight.class),(pageNo-1)*pageSize,pageSize);

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flight;

	}
	// 获取所有的航班数据
		public static List<TFlight> getAllFlight() {

			// 获取数据库连接
			Connection conn = UserService.getConnect();

			// QueryRunner Dbutils核心类
			QueryRunner runner = new QueryRunner();

			// String sql1 = "select * from t_flight as f join t_airplane as a on
			// f.f_a_no=a.a_no";
			String sql1 = "select * from t_flight";

			List<TFlight> flight = new ArrayList<>();

			try {
				// 查询所有的用户数据，结果放入 List<TFlight>
				flight = runner.query(conn, sql1, new BeanListHandler<TFlight>(TFlight.class));

				DbUtils.closeQuietly(conn);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flight;

		}

	// 查询航班数据
	public static List<TFlight> queryTFlight(String key) {

		// 获取数据库连接
		Connection conn = UserService.getConnect();

		// QueryRunner Dbutils核心类
		QueryRunner runner = new QueryRunner();

		key = "%" + key + "%";

		String sql1 = "select * from t_flight where f_start like ? or f_dist like ?";

		List<TFlight> flight = new ArrayList<>();

		try {

			// 查询所有的用户数据，结果放入 List<TUser>
			flight = runner.query(conn, sql1, new BeanListHandler<TFlight>(TFlight.class), key, key);

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flight;

	}

	// 获取所有的订单数据
	public static List<TOrder> getAllOrder() {

		// 获取数据库连接
		Connection conn = UserService.getConnect();

		// QueryRunner Dbutils核心类
		QueryRunner runner = new QueryRunner();

		// String sql1 = "select * from t_flight as f join t_airplane as a on
		// f.f_a_no=a.a_no";
		String sql1 = "select * from t_order, t_flight where t_order.o_f_no=t_flight.f_no";

		List<TOrder> order = new ArrayList<>();

		try {
			// 查询所有的用户数据，结果放入 List<TOrder>
			order = runner.query(conn, sql1, new BeanListHandler<TOrder>(TOrder.class));

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;

	}

	// 根据no获取航班
	public static TFlight getFlightByNo(int f_no) {

		Connection conn = UserService.getConnect();

		// QueryRunner Dbutils核心类
		QueryRunner runner = new QueryRunner();

		String sql1 = "select * from t_flight where f_no = ? ";

		List<TFlight> flight;
		try {
			flight = runner.query(conn, sql1, new BeanListHandler<TFlight>(TFlight.class), f_no);

			DbUtils.closeQuietly(conn);

			if (flight.size() > 0)
				return flight.get(0);
			else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
