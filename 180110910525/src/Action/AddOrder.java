package Action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import Service.UserService;

/**
 * Ô¤¶©
 */
@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = UserService.getConnect();

		// QueryRunner DbutilsºËÐÄÀà
		QueryRunner runner = new QueryRunner();
		
		String sql1 = "insert into t_order(o_f_no,o_f_start,o_f_dist,o_f_price)select f_no,f_start,f_dist,f_price from t_flight where f_no=1";
		
		
		request.getRequestDispatcher("QueryFlight").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
