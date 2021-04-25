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



@WebServlet("/QueryFlight")
public class QueryFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getServletContext().getContextPath());

		// 1.��ȡ���е��û�������
		List<TFlight> flight = UserService.getAllFlight();

		// 2. ������ת������ʾ��jsp��

		// �����ݷŵ�������
		request.setAttribute("flight", flight);
		request.setAttribute("menu_item", "BookFlight");
		System.out.print(flight);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/queryFlight.jsp");

		rd.forward(request, response);
	
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
