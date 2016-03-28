package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cores.Students;
import utils.MyUtils;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet(urlPatterns={"/userInfo"})
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession();
		  
	        // Kiểm tra người dùng login chưa
	        Students loginedUser = MyUtils.getLoginedUser(session);
	       
	        // Chưa login.
	        if (loginedUser == null) {
	            // Chuyển hướng về trang login.
	            response.sendRedirect(request.getContextPath() + "/login");
	            return;
	        }
	        // Ghi thông tin vào request trước khi forward.
	        //request.setAttribute("user", loginedUser);
	        
	        // Đã login rồi thì chuyển tiếp sang /WEB-INF/views/userInfoView.jsp
	        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
	        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
