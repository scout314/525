package Web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;
import flight.entity.TFlight;

/**
 * Servlet implementation class FlightInfo
 */
@WebServlet("/FlightInfo")
public class FlightInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String f_no = request.getParameter("f_no");

		// 1.��ȡnoΪ1�ĺ��������

		if (f_no != null) {
			TFlight flight = UserService.getFlightByNo(Integer.parseInt(f_no));
			request.setAttribute("flightinfo", flight);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/flightinfo.jsp");

			rd.forward(request, response);
		} else {
			System.out.println(f_no);
		}

		// TFlight flight = UserService.getFlightByNo(Integer.parseInt(f_no));

		// 2. ������ת������ʾ��jsp��

		// �����ݷŵ�������
		// request.setAttribute("flightinfo", flight);

		// RequestDispatcher rd =
		// request.getRequestDispatcher("WEB-INF/jsp/flightinfo.jsp");

		// rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
