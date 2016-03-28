package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import cores.BusStop;
import cores.Students;
import utils.DBUtils;
import utils.MyUtils;

/**
 * Servlet implementation class GetTrip
 */
@WebServlet(urlPatterns={"/getTrip"})
public class GetTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetTrip() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = MyUtils.getStoredConnection(request);
		HttpSession session = request.getSession();
		Students stu = (Students) session.getAttribute("loginedUser");
		List<BusStop> trip = new ArrayList<BusStop>();
		try {
			trip = DBUtils.getTrip(con,stu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JSONArray jsarr = new JSONArray();
		try {
		
			for(int i = 0 ; i < trip.size(); i++){
				
				BusStop bs = new BusStop(i+1);
				bs = trip.get(i);
				JSONObject json = new JSONObject();
				json.put("address", bs.getAddress());
				json.put("bid", bs.getBid());
				jsarr.put(i, json);
					
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print(jsarr.toString());
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
