package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import cores.BusStop;
import cores.Students;
import utils.DBUtils;
import utils.MyUtils;

/**
 * Servlet implementation class GetBusStopServlet
 */
@WebServlet(urlPatterns={"/getBusStop"})
public class GetBusStopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetBusStopServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Students stu = (Students) session.getAttribute("loginedUser");
		Connection con = MyUtils.getStoredConnection(request);
		BusStop bus = null;
		try {
			bus = DBUtils.findBusStop(con, stu.getBus_id());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter out = response.getWriter();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		JSONObject json = new JSONObject();
		try {
			json.put("busId", bus.getBid());
			json.put("address", bus.getAddress());

		} catch (JSONException e) {

			e.printStackTrace();
		}
		out.print(json.toString());

		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
