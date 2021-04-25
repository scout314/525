package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;
import flight.entity.TFlight;
import flight.entity.TOrder;

/**
 * Servlet implementation class MyOrderServlet
 */
@WebServlet("/MyOrder")
public class MyOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getServletContext().getContextPath());

		// 1.获取所有的用户的数据
		List<TOrder> order = UserService.getAllOrder();

		// 2. 把数据转发到显示的jsp中

		// 把数据放到请求中
		request.setAttribute("order", order);
		request.setAttribute("menu_item", "MyOrder");
		System.out.print(order);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/myOrder.jsp");

		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
