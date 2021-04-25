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

		// 1 ע������

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 2 ��������

			String url = "JDBC:mysql://localhost:3306/db_180110910525?useUnicode=true&characterEncoding=UTF-8";

			Connection conn = DriverManager.getConnection(url, "root", "123456");

			return conn;

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			System.out.println("���ݿ����Ӵ��󣡣�");

			e.printStackTrace();
		}

		return null;

	}

	

	/// �û���¼
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

	// ��ȡ���еĺ�������
	public static List<TFlight> getFlight(int pageSize,int pageNo) {

		// ��ȡ���ݿ�����
		Connection conn = UserService.getConnect();

		// QueryRunner Dbutils������
		QueryRunner runner = new QueryRunner();

		// String sql1 = "select * from t_flight as f join t_airplane as a on
		// f.f_a_no=a.a_no";
		String sql1 = "select * from t_flight limit ?,?";

		List<TFlight> flight = new ArrayList<>();

		try {
			// ��ѯ���е��û����ݣ�������� List<TFlight>
			flight = runner.query(conn, sql1, new BeanListHandler<TFlight>(TFlight.class),(pageNo-1)*pageSize,pageSize);

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flight;

	}
	// ��ȡ���еĺ�������
		public static List<TFlight> getAllFlight() {

			// ��ȡ���ݿ�����
			Connection conn = UserService.getConnect();

			// QueryRunner Dbutils������
			QueryRunner runner = new QueryRunner();

			// String sql1 = "select * from t_flight as f join t_airplane as a on
			// f.f_a_no=a.a_no";
			String sql1 = "select * from t_flight";

			List<TFlight> flight = new ArrayList<>();

			try {
				// ��ѯ���е��û����ݣ�������� List<TFlight>
				flight = runner.query(conn, sql1, new BeanListHandler<TFlight>(TFlight.class));

				DbUtils.closeQuietly(conn);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flight;

		}

	// ��ѯ��������
	public static List<TFlight> queryTFlight(String key) {

		// ��ȡ���ݿ�����
		Connection conn = UserService.getConnect();

		// QueryRunner Dbutils������
		QueryRunner runner = new QueryRunner();

		key = "%" + key + "%";

		String sql1 = "select * from t_flight where f_start like ? or f_dist like ?";

		List<TFlight> flight = new ArrayList<>();

		try {

			// ��ѯ���е��û����ݣ�������� List<TUser>
			flight = runner.query(conn, sql1, new BeanListHandler<TFlight>(TFlight.class), key, key);

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flight;

	}

	// ��ȡ���еĶ�������
	public static List<TOrder> getAllOrder() {

		// ��ȡ���ݿ�����
		Connection conn = UserService.getConnect();

		// QueryRunner Dbutils������
		QueryRunner runner = new QueryRunner();

		// String sql1 = "select * from t_flight as f join t_airplane as a on
		// f.f_a_no=a.a_no";
		String sql1 = "select * from t_order, t_flight where t_order.o_f_no=t_flight.f_no";

		List<TOrder> order = new ArrayList<>();

		try {
			// ��ѯ���е��û����ݣ�������� List<TOrder>
			order = runner.query(conn, sql1, new BeanListHandler<TOrder>(TOrder.class));

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;

	}

	// ����no��ȡ����
	public static TFlight getFlightByNo(int f_no) {

		Connection conn = UserService.getConnect();

		// QueryRunner Dbutils������
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
