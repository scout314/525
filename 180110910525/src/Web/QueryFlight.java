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



@WebServlet("/QueryFlightServlet")
public class QueryFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//1.获取用户输入 的查询关键字
		String key = request.getParameter("start");
		
		//2.查询机票数据
		List<TFlight> flight = UserService.queryTFlight(key);
		
		//3. 把数据转发到显示的jsp中
		
		//把数据放到请求中
		request.setAttribute("flight", flight);
		request.setAttribute("menu_item", "QueryFlightServlet");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/queryFlight.jsp");
		
			
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
