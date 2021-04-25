package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Page;
import Service.UserService;
import flight.entity.TFlight;

/**
 * Servlet implementation class BookFlight
 */
@WebServlet("/BookFlight")
public class BookFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getServletContext().getContextPath());

		String pageNo = request.getParameter("pageNo");
		if(pageNo==null||pageNo.length()==0) {
			pageNo = "1";
		}
		
		Page page = new Page(3,1,2);
		
		// 1.获取所有的用户的数据
		//List<TFlight> flight = UserService.getAllFlight();
		List<TFlight> flight = UserService.getFlight(2,Integer.parseInt(pageNo));

		// 2. 把数据转发到显示的jsp中

		// 把数据放到请求中
		request.setAttribute("flight", flight);
		request.setAttribute("menu_item", "BookFlight");
		request.setAttribute("page", page);
		System.out.print(flight);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/bookFlight.jsp");

		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
